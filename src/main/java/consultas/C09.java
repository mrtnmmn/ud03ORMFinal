package consultas;

import DAOModels.DAOVehiculoClientes;
import VOModels.VehiculoClientes;

import java.util.Iterator;
import java.util.List;

public class C09 {

    public DAOVehiculoClientes vc = new DAOVehiculoClientes();

    public void getCostesAltos() {
        Iterator it = vc.getCostesAltos();
        while (it.hasNext()){
            Object[]row = (Object[]) it.next();
            System.out.println("\tMatricula: " + row[0] + "\tMarca: " + row[1] + "\tPrecio: " + row[2]);
        }
    }

    public static void main(String[] args) {
        C09 c09 = new C09();
        c09.getCostesAltos();
    }
}
