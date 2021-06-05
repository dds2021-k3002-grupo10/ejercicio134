package domain.business.servicios;

import domain.business.dao.ArticuloDaoImpl;
import domain.business.model.Articulo;
import domain.business.model.DetalleArticulo;
import domain.business.model.Envase;

import java.util.*;

public class DetalleArticuloServiceImpl {
    ArticuloDaoImpl listArticulos = null;

    public void ingresarArticulos(DetallePedidoServiceImpl detallePedidoServiceImpl) {

        List<DetalleArticulo> listDetalleArticulo = new ArrayList<>();
        int count = 0;
        //agrego articulos por fecha
        for (String FechaEntrega : detallePedidoServiceImpl.getFechaEntrega()) {
            count++;
            System.out.println("********* FECHA DE ENTREGA: " + FechaEntrega + " nro:" + count);
            this.muestraArticulosDisponibles();

            Scanner leerCodigoArticulo = new Scanner(System.in);
            System.out.println("INGRESE CODIGO ARTICULO: ");
            Long codigoArticuloEntrado = leerCodigoArticulo.nextLong();

            this.AgregarDatosDeArticulos(codigoArticuloEntrado, FechaEntrega, listDetalleArticulo);

        }

        //Acá setea todos los articulos para el pedido
        detallePedidoServiceImpl.setDetalleArticulos(listDetalleArticulo);

    }

    private void muestraArticulosDisponibles() {
        //instancio los articulos
        listArticulos = ArticuloDaoImpl.getInstance();
        List<Articulo> Articulos = listArticulos.getArticulos();
        System.out.println("Ingrese uno de estos codigo disponibles: ");
        for (Articulo articulo : Articulos) {
            System.out.println("Codigo Articulo: " + articulo.getCodigo() + " Descripcion Articulo:" + articulo.getDescripcion());
        }
    }

    private void AgregarDatosDeArticulos(Long codigoArticuloEntrado, String FechaEntrega, List<DetalleArticulo> listDetalleArticulo) {
        //SETEO detallePedidoServiceImpl
        listArticulos = ArticuloDaoImpl.getInstance();
        List<Articulo> articulos = listArticulos.getArticulos();
        List<Articulo> articuloAGuardar = new ArrayList<>();

        for (Articulo articulo : articulos) {
            //Me posiciono en el articulo ingresado
            if (articulo.getCodigo() == codigoArticuloEntrado) {
                //tolerancia Ancho
                Scanner toleranciaAncho = new Scanner(System.in);
                System.out.println("INGRESE TOLERANCIA DE ANCHO: ");
                Double respuestatoleranciaAncho = toleranciaAncho.nextDouble();
                //toleranciaDiametro
                Scanner toleranciaDiametro = new Scanner(System.in);
                System.out.println("INGRESE TOLERANCIA DE DIAMETRO: ");
                Double respuestaToleranciaDiametro = toleranciaDiametro.nextDouble();
                //toleranciaLargo
                Scanner toleranciaLargo = new Scanner(System.in);
                System.out.println("INGRESE TOLERANCIA DE LARGO: ");
                Double respuestaToleranciaLargo = toleranciaLargo.nextDouble();
                //cantidadArticulos
                Scanner cantidadArticulos = new Scanner(System.in);
                System.out.println("INGRESE CANTIDAD DE ARTICULOS: ");
                Long respuestaCantArticulo = cantidadArticulos.nextLong();

                //agregamos detalleArticulo
                DetalleArticulo detalleArticulo = new DetalleArticulo();
                detalleArticulo.setCodigo(articulo.getCodigo());
                detalleArticulo.setFechaEntrega(FechaEntrega);
                detalleArticulo.setToleranciaAncho(respuestatoleranciaAncho);
                detalleArticulo.setToleranciaDiametro(respuestaToleranciaDiametro);
                detalleArticulo.setToleranciaLargo(respuestaToleranciaLargo);
                detalleArticulo.setCantidad(respuestaCantArticulo);

                for (Envase envase : articulo.getEnvases()) {
                    System.out.println("Si quiere, elija un codigo de envases: " + envase.getCodigoEnvases() + " su capacidad es: " + envase.getCapacidad());
                }

                Scanner seleccionDeEnvase = new Scanner(System.in);
                System.out.println("¿Quiere elijir un codEnvase? ingrese S: si o N: no:  ");
                String respuestaSeleccionDeEnvase = seleccionDeEnvase.nextLine().toUpperCase();

                if (respuestaSeleccionDeEnvase.equals("S")) {
                    //codigoEnvase
                    Scanner envasesSeleccionado = new Scanner(System.in);
                    System.out.println("INGRESE CODIGO DE ENVASE: ");
                    Long respuestaCodigoEnvase = envasesSeleccionado.nextLong();
                    for (Envase envase : articulo.getEnvases()) {

                        if (envase.getCodigoEnvases().equals(respuestaCodigoEnvase)) {
                            detalleArticulo.setEnvase(envase);
                        }
                        listDetalleArticulo.add(detalleArticulo);
                    }
                } else {

                    Random random = new Random();
                    int indexRandom = 0;
                    for (int i = 0; i < articulo.getEnvases().size(); i++) {
                        indexRandom = random.nextInt(articulo.getEnvases().size());
                    }
                    detalleArticulo.setEnvase(articulo.getEnvases().get(indexRandom));
                    listDetalleArticulo.add(detalleArticulo);

                }

            }

        }
    }
}
