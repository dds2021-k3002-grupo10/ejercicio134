package views;

import domain.business.servicios.ClienteServiceImpl;
import domain.business.servicios.DetalleArticuloServiceImpl;
import domain.business.servicios.DetallePedidoServiceImpl;
import domain.business.servicios.PeriocidadServiceImpl;

import java.text.ParseException;
import java.util.Scanner;

public class ViewPedido {
    public void hacerPedido() throws ParseException {


        DetallePedidoServiceImpl detallePedidoServiceImpl = new DetallePedidoServiceImpl();

        //ingresar codCliente
        ClienteServiceImpl clienteServiceImpl = new ClienteServiceImpl();
        clienteServiceImpl.agregaCliente(detallePedidoServiceImpl);

        //ingresar fechaEntrega
        Scanner leerFecha = new Scanner(System.in);
        System.out.println("Ingrese una fecha (dd/mm/aaaa): ");
        String fecha = leerFecha.nextLine();

        //ingresar cantiddEntregas
        Long cantidadEntrega = detallePedidoServiceImpl.ingresaCantidadEntrega();

        //Ingrese la periocida de las entregas:
        PeriocidadServiceImpl PeriocidadServiceImpl = new PeriocidadServiceImpl();
        PeriocidadServiceImpl.entrarPeriocidadEntrega(cantidadEntrega, fecha, detallePedidoServiceImpl);

        //ingreso de articulos por fecha
        DetalleArticuloServiceImpl DetalleArticuloServiceImpl = new DetalleArticuloServiceImpl();
        DetalleArticuloServiceImpl.ingresarArticulos(detallePedidoServiceImpl);

        //Muestro IdentificadorPedido
        detallePedidoServiceImpl.setIdentificadorPedido(111111L);
        System.out.println("***************mensaje*********");
        System.out.println("el pedido tiene este nro d identificacion: " + detallePedidoServiceImpl.getIdentificadorPedido());
        System.out.println("Codigo de cliente: " + detallePedidoServiceImpl.getCodigoCliente());


        System.out.println("***************Fin*********");
    }
}
