package domain.business.model;

public class Envase {
    private Long codigoEnvases;
    private Double capacidad;

    public Envase(Long codigoEnvases, Double capacidad) {
        this.codigoEnvases = codigoEnvases;
        this.capacidad = capacidad;
    }

    public Envase() {
    }

    public Long getCodigoEnvases() {
        return codigoEnvases;
    }

    public void setCodigoEnvases(Long codigoEnvases) {
        this.codigoEnvases = codigoEnvases;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

}
