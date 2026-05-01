package gov.data.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "localidade", uniqueConstraints = @UniqueConstraint(columnNames = {"municipio", "uf"}))
public class Localidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String municipio;

    private String uf;

    @OneToMany(mappedBy = "localidade")
    private List<Servidor> servidores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }
}