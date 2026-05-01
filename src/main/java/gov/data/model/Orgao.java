package gov.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "orgao")
public class Orgao{
    @Id
    private Integer coOrgao;

    private String noOrgao;

    @OneToMany(mappedBy = "orgao")
    private List<Servidor> servidores;

    public Integer getCoOrgao() {
        return coOrgao;
    }

    public void setCoOrgao(Integer coOrgao) {
        this.coOrgao = coOrgao;
    }

    public String getNoOrgao() {
        return noOrgao;
    }

    public void setNoOrgao(String noOrgao) {
        this.noOrgao = noOrgao;
    }

    public List<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }
}