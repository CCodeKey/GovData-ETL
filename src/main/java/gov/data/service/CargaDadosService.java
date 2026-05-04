package gov.data.service;

import com.opencsv.bean.CsvToBeanBuilder;
import gov.data.dto.AuxilioPreEscolarDTO;
import gov.data.model.Localidade;
import gov.data.model.Orgao;
import gov.data.model.Servidor;
import gov.data.model.repository.LocalidadeRepository;
import gov.data.model.repository.OrgaoRepository;
import gov.data.model.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class CargaDadosService {

    @Autowired
    private ServidorRepository servidorRepository;

    @Autowired
    private OrgaoRepository orgaoRepository;

    @Autowired
    private LocalidadeRepository localidadeRepository;

    @Transactional
    public void carregarDadosIniciais() {
        try {
            var resource = getClass().getClassLoader().getResourceAsStream("data/AUX_PRE_ESCOLAR_202602.csv");

            if (resource == null) {
                System.err.println("Arquivo CSV não encontrado!");
                return;
            }

            // Usando Latin1 (ISO-8859-1) para evitar erros em acentos do governo
            Reader reader = new InputStreamReader(resource, StandardCharsets.ISO_8859_1);

            List<AuxilioPreEscolarDTO> dtos = new CsvToBeanBuilder<AuxilioPreEscolarDTO>(reader)
                    .withType(AuxilioPreEscolarDTO.class)
                    .withSeparator(';')
                    .build()
                    .parse();

            for (AuxilioPreEscolarDTO dto : dtos) {
                // 1. Tratamento de Nulos
                String grupoCargo = (dto.getGrupoCargo() == null || dto.getGrupoCargo().isBlank())
                        ? "NÃO INFORMADO" : dto.getGrupoCargo().toUpperCase();

                // 2. Padronização de Sinônimos
                String cargoTratado = padronizarCargo(dto.getCargoFuncao());

                // 3. Persistência Normalizada
                // Criando Órgão
                Orgao orgao = new Orgao();
                orgao.setCoOrgao(Integer.parseInt(dto.getCoOrgao()));
                orgao.setNoOrgao(dto.getNoOrgao());
                orgao = orgaoRepository.save(orgao);

                // Criando Localidade
                Localidade local = new Localidade();
                local.setMunicipio(dto.getNoMunicipioUorg());
                local.setUf(dto.getUfUorg());
                local = localidadeRepository.save(local);

                // Criando Servidor
                Servidor servidor = new Servidor();
                servidor.setMatServ(Integer.parseInt(dto.getMatServ()));
                servidor.setNoServidor(dto.getNoServidor());
                servidor.setGrupoCargo(grupoCargo);
                servidor.setCargoFuncao(cargoTratado);
                servidor.setOrgao(orgao);
                servidor.setLocalidade(local);

                servidorRepository.save(servidor);
            }

            System.out.println("Carga finalizada com sucesso: " + dtos.size() + " registros.");

        } catch (Exception e) {
            System.err.println("Erro na carga: " + e.getMessage());
        }
    }

    private String padronizarCargo(String cargo) {
        if (cargo == null) return "OUTROS";
        String c = cargo.toUpperCase();

        // Exemplo de resolução de sinônimos
        if (c.contains("PROF") || c.contains("DOCENTE")) return "PROFESSOR";
        if (c.contains("ADM") || c.contains("ANALISTA")) return "ADMINISTRATIVO";
        if (c.contains("TEC")) return "TECNICO";

        return c;
    }
}