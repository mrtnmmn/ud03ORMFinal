package consultas;

import DAOModels.DAOVehiculos;

import java.util.Iterator;

public class C03 {

    public DAOVehiculos v = new DAOVehiculos();

    public void listNoAlquilados() {

        System.out.println("Listando vehiculos no alquilados: ");

        Iterator it = v.getNoAlquilados();

        while (it.hasNext()) {
            Object[]row = (Object[]) it.next();
            System.out.println("Matricula: " + row[0]);
        }
    }

    public static void main(String[] args) {
        C03 c03 = new C03();
        c03.listNoAlquilados();
    }
}
