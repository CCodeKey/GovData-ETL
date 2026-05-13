package gov.data.dto;

import com.opencsv.bean.CsvBindByName;

public class AuxilioPreEscolarDTO {

    @CsvBindByName(column = "CO_ORGAO")
    private String coOrgao;

    @CsvBindByName(column = "NO_ORGAO")
    private String noOrgao;

    @CsvBindByName(column = "NO_UORG")
    private String noUorg;

    @CsvBindByName(column = "NO_MUNICIPIO_UORG")
    private String noMunicipioUorg;

    @CsvBindByName(column = "UF_UORG")
    private String ufUorg;

    @CsvBindByName(column = "MAT_SERV")
    private String matServ;

    @CsvBindByName(column = "NO_SERVIDOR")
    private String noServidor;

    @CsvBindByName(column = "GRUPO_CARGO")
    private String grupoCargo;

    @CsvBindByName(column = "CARGO_FUNCAO")
    private String cargoFuncao;

    @CsvBindByName(column = "AUX_PRE_ESCOLAR")
    private String valorAuxilio;

    @CsvBindByName(column = "DESC_COTA_PARTE")
    private String cotaParte;

    public AuxilioPreEscolarDTO() {}

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