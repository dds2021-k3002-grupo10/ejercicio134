package domain.business.dao;
import domain.business.model.Articulo;
import domain.business.model.Envase;

import java.util.ArrayList;
import java.util.List;
public class ArticuloDaoImpl {

    /*Singleton*/
    public static ArticuloDaoImpl instancia = null;
    private List articulo = null;

    private ArticuloDaoImpl() {
    }

    public static ArticuloDaoImpl getInstance() {
        if (instancia == null) {
            instancia = new ArticuloDaoImpl();
        }
        return instancia;
    }

    public List getArticulos() {

        if (articulo == null) {
            articulo = new ArrayList();
            /*primer Articulo con sus envases*/
            ArrayList<Envase> envase = new ArrayList<>();
            envase.add(new Envase(1L, 100.0));
            envase.add(new Envase(2L, 200.0));
            envase.add(new Envase(3L, 300.0));
            envase.add(new Envase(4L, 400.0));
            /*agrego*/
            articulo.add(new Articulo(1L, "CAÑO LARGO", 35.0, 100.0, envase));

            /*Segundo Articulo con sus envases*/
            ArrayList<Envase> envase2 = new ArrayList<>();
            envase2.add(new Envase(5L, 100.0));
            envase2.add(new Envase(6L, 200.0));
            /*agrego*/
            articulo.add(new Articulo(2L, "CAÑO CORTO", 35.0, 20.0, envase2));

            /*Tercer Articulo con sus envases*/
            ArrayList<Envase> envase3 = new ArrayList<>();
            envase3.add(new Envase(7L, 3300.0));
            envase3.add(new Envase(8L, 2200.0));
            /*agrego*/
            articulo.add(new Articulo(3L, "CAÑO MEDIANO", 35.0, 50.0, envase3));

        }
        return articulo;

    }

}
