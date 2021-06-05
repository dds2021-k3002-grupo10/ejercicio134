package domain.business.servicios;

import domain.business.model.DetalleArticulo;

import java.util.List;
import java.util.Scanner;
public class DetallePedidoServiceImpl {
    private Long codigoCliente;
    private List<String> fechaEntrega;
    private Long cantidadEntrega;
    private String periocidad;
    private List<DetalleArticulo> detalleArticulos;
    private Long identificadorPedido;

    public DetallePedidoServiceImpl() {
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public List<String> getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(List<String> fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Long getCantidadEntrega() {
        return cantidadEntrega;
    }

    public void setCantidadEntrega(Long cantidadEntrega) {
        this.cantidadEntrega = cantidadEntrega;
    }

    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }

    public List<DetalleArticulo> getDetalleArticulos() {
        return detalleArticulos;
    }

    public void setDetalleArticulos(List<DetalleArticulo> detalleArticulos) {
        this.detalleArticulos = detalleArticulos;
    }

    public Long getIdentificadorPedido() {
        return identificadorPedido;
    }

    public void setIdentificadorPedido(Long identificadorPedido) {
        this.identificadorPedido = identificadorPedido;
    }

    public Long ingresaCantidadEntrega() {
        Scanner leerCantidadEntrega = new Scanner(System.in);
        System.out.println("Ingrese la Cantida de entregas: ");
        Long cantidadDeEntrega = leerCantidadEntrega.nextLong();
        this.setCantidadEntrega(cantidadDeEntrega);

        return cantidadDeEntrega;
    }

}
