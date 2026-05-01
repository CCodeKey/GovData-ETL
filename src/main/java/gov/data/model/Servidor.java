package gov.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "servidor")
public class Servidor {
    @Id
    private Integer matServ;

    private String noServidor;

    private String grupoCargo;

    private String cargoFuncao;

    @ManyToOne
    @JoinColumn(name = "orgao_id")
    private Orgao orgao;

    @ManyToOne
    @JoinColumn(name = "localidade_id")
    private Localidade localidade;

    @OneToOne(mappedBy = "servidor", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    public Integer getMatServ() {
        return matServ;
    }

    public void setMatServ(Integer matServ) {
        this.matServ = matServ;
    }

    public String getNoServidor() {
        return noServidor;
    }

    public void setNoServidor(String noServidor) {
        this.noServidor = noServidor;
    }

    public String getGrupoCargo() {
        return grupoCargo;
    }

    public void setGrupoCargo(String grupoCargo) {
        this.grupoCargo = grupoCargo;
    }

    public String getCargoFuncao() {
        return cargoFuncao;
    }

    public void setCargoFuncao(String cargoFuncao) {
        this.cargoFuncao = cargoFuncao;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}