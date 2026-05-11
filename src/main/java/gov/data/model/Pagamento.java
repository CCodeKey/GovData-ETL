package gov.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorAuxilio;

    private Double cotaParte;

    private String mesReferencia;

    @ManyToOne
    @JoinColumn(name = "servidor_id")
    private Servidor servidor;

    public Pagamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorAuxilio() {
        return valorAuxilio;
    }

    public void setValorAuxilio(Double valorAuxilio) {
        this.valorAuxilio = valorAuxilio;
    }

    public Double getCotaParte() {
        return cotaParte;
    }

    public void setCotaParte(Double cotaParte) {
        this.cotaParte = cotaParte;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }
}