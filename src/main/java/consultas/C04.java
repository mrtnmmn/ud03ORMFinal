package consultas;

import DAOModels.DAOVehiculoClientes;

import java.util.Iterator;

public class C04 {

    public DAOVehiculoClientes vc = new DAOVehiculoClientes();

    public void listAlquileresMatricula() {

        System.out.println("Listando alquileres por matricula");

        Iterator it = vc.getAlquileresMatricula();

        while (it.hasNext()) {
            Object[]row = (Object[]) it.next();
            System.out.println("Nombre: " + row[0] + "\tMatricula: " + row[1] + "\tMarca:" + row[2]
                + "\tDias: " + row[3] + "\tSeguro: " + row[4] + "\tPrecio: " + row[5]);
        }
    }

    public static void main(String[] args) {
        C04 c04 = new C04();
        c04.listAlquileresMatricula();
    }

}
