package consultas;

import DAOModels.DAOVehiculoClientes;
import conexion.Conexion;

import java.util.Iterator;

public class C06 {

    public DAOVehiculoClientes vc = new DAOVehiculoClientes();

    public void listAlquileresOrder() {

        Iterator it = vc.getAlquileresOrder();

        System.out.println("Listando alquileres (Orden: nombres, matricula): ");

        while (it.hasNext()) {
            Object[] row = (Object[]) it.next();
            System.out.println("Matricula: " + row[0] + "\tDni: " + row[1] + "\tNombre:" + row[2] + "\tTelefono: " + row[3] +
                    "\tDias: " + row[4] + "\tPrecio: " + row[5]);
        }
    }

    public static void main(String[] args) {
        C06 c06 = new C06();
        c06.listAlquileresOrder();
    }
}
