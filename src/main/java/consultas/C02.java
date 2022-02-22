package consultas;

import DAOModels.DAOVehiculos;
import VOModels.Vehiculos;

import java.util.Iterator;

public class C02 {

    public DAOVehiculos v = new DAOVehiculos();

    public void listPrecioYDias(){
        Iterator iterator = v.getListPrecioYDias();
        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("matricula: " + row[0] + " num_dias: " + row[1] + " total cobrado:" + row[2]);
        }
    }
    /*test 02*/
    public static void main(String[] args) {
        C02 c02 = new C02();
        c02.listPrecioYDias();
    }
}
