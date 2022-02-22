package consultas;

import DAOModels.DAOVehiculoClientes;
import conexion.Conexion;

import java.util.Iterator;

public class C06 {

    public DAOVehiculoClientes vc = new DAOVehiculoClientes();

    public void listAlquileresOrder() {

        Iterator it = vc.getAlquileresOrder();
        while (it.hasNext()) {
            Object[] row = (Object[]) it.next();
            System.out.println("Matricula: " + row[0] + "\nDni: " + row[1] + "\nNombre:" + row[2] + "\nTelefono: " + row[3] +
                    "\nDias: " + row[4] + "\nPrecio: " + row[5]);
        }
    }

    public static void main(String[] args) {
        C06 c06 = new C06();
        c06.listAlquileresOrder();
    }
}
