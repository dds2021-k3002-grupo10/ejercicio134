package domain.business.servicios;

import java.util.Scanner;

public class ClienteServiceImpl {
    public void agregaCliente(DetallePedidoServiceImpl detallePedidoServiceImpl) {

        Scanner leerIdCodigo = new Scanner(System.in);
        System.out.println("Ingrese su codigo Cliente: ");

        //SETEO detallePedidoServiceImpl
        detallePedidoServiceImpl.setCodigoCliente(leerIdCodigo.nextLong());

    }
}
