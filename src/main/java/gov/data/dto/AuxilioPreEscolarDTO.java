package gov.data.dto;

/**
 * Representa o esquema original do CSV de Auxílio Pré-Escolar.
 * Responsável por capturar os dados brutos antes do tratamento e normalização.
 */
public class AuxilioPreEscolarDTO {

    // Campos baseados nas colunas do arquivo dados.gov.br
    private String coOrgao;          // Código do Órgão
    private String noOrgao;          // Nome do Órgão
    private String noUorg;           // Nome da Unidade Organizacional
    private String noMunicipioUorg;  // Município (Para desmembramento de endereço)
    private String ufUorg;           // UF
    private String matServ;          // Matrícula do Servidor (ID original)
    private String noServidor;       // Nome do Servidor
    private String grupoCargo;       // Grupo do Cargo (Alvo de tratamento de nulos)
    private String cargoFuncao;      // Cargo/Função (Alvo de identificação de sinônimos)
    private String valorAuxilio;     // Valor do Auxílio (String para evitar erro de parse inicial)
    private String cotaParte;        // Desconto da Cota Parte

    // Construtor padrão
    public AuxilioPreEscolarDTO() {
    }

    // Getters e Setters
    public String getCoOrgao() { return coOrgao; }
    public void setCoOrgao(String coOrgao) { this.coOrgao = coOrgao; }

    public String getNoOrgao() { return noOrgao; }
    public void setNoOrgao(String noOrgao) { this.noOrgao = noOrgao; }

    public String getNoUorg() { return noUorg; }
    public void setNoUorg(String noUorg) { this.noUorg = noUorg; }

    public String getNoMunicipioUorg() { return noMunicipioUorg; }
    public void setNoMunicipioUorg(String noMunicipioUorg) { this.noMunicipioUorg = noMunicipioUorg; }

    public String getUfUorg() { return ufUorg; }
    public void setUfUorg(String ufUorg) { this.ufUorg = ufUorg; }

    public String getMatServ() { return matServ; }
    public void setMatServ(String matServ) { this.matServ = matServ; }

    public String getNoServidor() { return noServidor; }
    public void setNoServidor(String noServidor) { this.noServidor = noServidor; }

    public String getGrupoCargo() { return grupoCargo; }
    public void setGrupoCargo(String grupoCargo) { this.grupoCargo = grupoCargo; }

    public String getCargoFuncao() { return cargoFuncao; }
    public void setCargoFuncao(String cargoFuncao) { this.cargoFuncao = cargoFuncao; }

    public String getValorAuxilio() { return valorAuxilio; }
    public void setValorAuxilio(String valorAuxilio) { this.valorAuxilio = valorAuxilio; }

    public String getCotaParte() { return cotaParte; }
    public void setCotaParte(String cotaParte) { this.cotaParte = cotaParte; }

    @Override
    public String toString() {
        return "CargaDTO{" + "servidor='" + noServidor + '\'' + ", cargo='" + cargoFuncao + '\'' + '}';
    }
}