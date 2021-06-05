package domain.business.model;

import java.util.List;

public class Articulo {
    private Long codigo;
    private String descripcion;
    private double diametro;
    private double ancho;
    private List<Envase> envases;

    public Articulo() {
    }

    public Articulo(Long codigo, String descripcion, double diametro, double ancho, List<Envase> envases) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.diametro = diametro;
        this.ancho = ancho;
        this.envases = envases;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public List<Envase> getEnvases() {
        return envases;
    }

    public void setEnvases(List<Envase> envases) {
        this.envases = envases;
    }

}
