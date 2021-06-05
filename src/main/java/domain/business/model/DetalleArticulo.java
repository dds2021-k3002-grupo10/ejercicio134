package domain.business.model;

public class DetalleArticulo extends Articulo{

    private Envase envase;
    private String fechaEntrega;
    private Double toleranciaDiametro;
    private Double toleranciaLargo;
    private Double toleranciaAncho;
    private Long cantidad;

    public DetalleArticulo() {
    }


    public Envase getEnvase() {
        return envase;
    }

    public void setEnvase(Envase envase) {
        this.envase = envase;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Double getToleranciaDiametro() {
        return toleranciaDiametro;
    }

    public void setToleranciaDiametro(Double toleranciaDiametro) {
        this.toleranciaDiametro = toleranciaDiametro;
    }

    public Double getToleranciaLargo() {
        return toleranciaLargo;
    }

    public void setToleranciaLargo(Double toleranciaLargo) {
        this.toleranciaLargo = toleranciaLargo;
    }

    public Double getToleranciaAncho() {
        return toleranciaAncho;
    }

    public void setToleranciaAncho(Double toleranciaAncho) {
        this.toleranciaAncho = toleranciaAncho;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
