package consultas;

import DAOModels.DAOVehiculos;
import VOModels.Vehiculos;

import java.util.Iterator;

public class C02 {

    public DAOVehiculos v = new DAOVehiculos();

    public void listPrecioYDias(){
        Iterator it= v.getListPrecioYDias();
        while (it.hasNext()){
            Object[]row = (Object[]) it.next();
            System.out.println("\tMatricula: " + row[0] + "\tDias: " + row[1] + "\tImporte total: " + row[2]);
        }
    }
    /*test 02*/
    public static void main(String[] args) {
        C02 c02 = new C02();
        c02.listPrecioYDias();
    }
}
