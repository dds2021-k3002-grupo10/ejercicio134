package domain.business.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PeriocidadServiceImpl {
    public List<String> periocidadEntrega(Long cantidad, String fechaString, String periocidad) throws ParseException {
//calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
        List<String> listFecha = new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date dateFecha = formatter.parse(fechaString);
        Calendar calendario = Calendar.getInstance();
        // METER ACA PATRON   Strategi
        //VER FECHA, ESTA FALLANDO
        if (periocidad.equals(PeriocidadEnum.UNICO.toString())) {
            listFecha.add(fechaString);
        } else if (periocidad.equals(PeriocidadEnum.SEMANAL.toString())) {
            listFecha.add(fechaString);

            for (int i = 1; i < cantidad; ++i) {

                calendario.setTime(dateFecha);
                calendario.add(Calendar.DAY_OF_YEAR, 7);
                dateFecha = calendario.getTime();
                String convertido = formatter.format(dateFecha);
                fechaString = convertido;  // fechaString es una nueva fecha

                listFecha.add(fechaString);

            }

        } else if (periocidad.equals(PeriocidadEnum.MENSUAL.toString())) {
            for (int i = 1; i < cantidad; ++i) {
                calendario.setTime(dateFecha);
                calendario.add(Calendar.MONTH, 1);
                dateFecha = calendario.getTime();
                String convertido = formatter.format(dateFecha);
                fechaString = convertido;  // fechaString es una nueva fecha

                listFecha.add(fechaString);
            }
        }
        return listFecha;
    }

    public void entrarPeriocidadEntrega(Long cantidadEntrega, String fecha, DetallePedidoServiceImpl detallePedidoServiceImpl) throws ParseException {
        Scanner leerPeriocidad = new Scanner(System.in);
        System.out.println("Ingrese Periocidad de entrega como: " + PeriocidadEnum.UNICO + " o " + PeriocidadEnum.SEMANAL + " o " + PeriocidadEnum.MENSUAL);
        String periocidadStr = leerPeriocidad.next().toUpperCase();

        List<String> fechasDeEntrega = new ArrayList<>();
        fechasDeEntrega = this.periocidadEntrega(cantidadEntrega, fecha, periocidadStr);

        //SETEO detallePedidoServiceImpl
        detallePedidoServiceImpl.setPeriocidad(periocidadStr);
        //SETEO detallePedidoServiceImpl
        detallePedidoServiceImpl.setFechaEntrega(fechasDeEntrega);

        fechasDeEntrega.forEach((cadena) -> {
            System.out.println("las fechas de entrega es: " + cadena);
        });

    }
}
