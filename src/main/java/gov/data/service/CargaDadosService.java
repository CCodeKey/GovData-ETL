package gov.data.service;

import com.opencsv.bean.CsvToBeanBuilder;
import gov.data.dto.AuxilioPreEscolarDTO;
import gov.data.model.*;
import gov.data.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CargaDadosService {

    @Autowired private ServidorRepository servidorRepository;
    @Autowired private OrgaoRepository orgaoRepository;
    @Autowired private LocalidadeRepository localidadeRepository;
    @Autowired private PagamentoRepository pagamentoRepository;

    private final Map<Integer, Orgao> orgaoCache = new HashMap<>();
    private final Map<String, Localidade> localidadeCache = new HashMap<>();

    @Transactional
    public void carregarDadosIniciais() {
        try {
            var resource = getClass().getClassLoader().getResourceAsStream("data/AUX_PRE_ESCOLAR_202602.csv");
            if (resource == null) {
                System.err.println("Arquivo CSV não encontrado!");
                return;
            }

            Reader reader = new InputStreamReader(resource, StandardCharsets.ISO_8859_1);

            List<AuxilioPreEscolarDTO> dtos = new CsvToBeanBuilder<AuxilioPreEscolarDTO>(reader)
                    .withType(AuxilioPreEscolarDTO.class)
                    .withSeparator(';')
                    .build()
                    .parse();

            System.out.println("Iniciando carga...");
            long inicio = System.currentTimeMillis();
            int contador = 0;

            for (AuxilioPreEscolarDTO dto : dtos) {
                // LIMITE: 5.000 registros para fins didáticos, poupa 29 minutos de tempo de vida
                if (contador >= 5000) break;

                try {
                    if (dto.getValorAuxilio() == null) continue;

                    double vAux = Double.parseDouble(dto.getValorAuxilio().replace(",", "."));
                    double vCota = Double.parseDouble(dto.getCotaParte().replace(",", "."));
                    if (vAux <= 0) continue;

                    // 1. Órgão com Cache e Flush
                    Integer coOrgao = Integer.parseInt(dto.getCoOrgao());
                    Orgao orgao = orgaoCache.computeIfAbsent(coOrgao, id ->
                            orgaoRepository.findById(id).orElseGet(() -> {
                                Orgao n = new Orgao();
                                n.setCoOrgao(id);
                                n.setNoOrgao(dto.getNoOrgao());
                                return orgaoRepository.saveAndFlush(n);
                            })
                    );

                    // 2. Localidade com Cache e Flush
                    String m = dto.getNoMunicipioUorg().trim().toUpperCase();
                    String u = dto.getUfUorg().trim().toUpperCase();
                    String localKey = m + "|" + u;
                    Localidade local = localidadeCache.computeIfAbsent(localKey, key ->
                            localidadeRepository.findByMunicipioAndUf(m, u)
                                    .orElseGet(() -> {
                                        Localidade n = new Localidade();
                                        n.setMunicipio(m);
                                        n.setUf(u);
                                        return localidadeRepository.saveAndFlush(n);
                                    })
                    );

                    // 3. Servidor com Flush
                    int matricula = Integer.parseInt(dto.getMatServ());
                    Servidor servidor = servidorRepository.findById(matricula).orElseGet(() -> {
                        Servidor s = new Servidor();
                        s.setMatServ(matricula);
                        s.setNoServidor(dto.getNoServidor());
                        s.setOrgao(orgao);
                        s.setLocalidade(local);
                        s.setCargoFuncao(padronizarCargo(dto.getCargoFuncao()));
                        return servidorRepository.saveAndFlush(s);
                    });

                    // 4. Pagamento
                    Pagamento p = new Pagamento();
                    p.setServidor(servidor);
                    p.setValorAuxilio(vAux);
                    p.setCotaParte(vCota);
                    p.setMesReferencia("2026-02");
                    pagamentoRepository.saveAndFlush(p);

                    contador++;

                    // Feedback visual a cada 1000 linhas para não parecer que travou
                    if (contador % 1000 == 0) {
                        System.out.println("Processados: " + contador + " registros...");
                    }

                } catch (Exception e) {
                    continue;
                }
            }

            long fim = System.currentTimeMillis();
            System.out.println("SUCESSO! Foram carregados " + contador + " registros.");
            System.out.println("Tempo total de processamento: " + (fim - inicio) / 1000 + " segundos.");

        } catch (Exception e) {
            System.err.println("Erro crítico na carga: " + e.getMessage());
        }
    }

    private String padronizarCargo(String cargo) {
        if (cargo == null) return "OUTROS";
        String c = cargo.toUpperCase();
        if (c.contains("PROF") || c.contains("DOCENTE")) return "PROFESSOR";
        if (c.contains("ADM") || c.contains("ANALISTA")) return "ADMINISTRATIVO";
        if (c.contains("TEC")) return "TECNICO";
        return c;
    }
}