package consultas;

import DAOModels.DAOVehiculos;
import VOModels.Vehiculos;

import java.util.List;

public class C01 {


    public DAOVehiculos v = new DAOVehiculos();

    public void ListGrupos() {

    }

    public static void main(String[] args) {

        System.out.println("Generarando un listado con todos los vehículos de los grupos E, F y G.");

        List<Vehiculos> lista = generateListVehiculoGroups();
        for (Vehiculos v: lista) {
            System.out.println(v.getMatricula() + v.getGrupo());
        }
    }

    public static void main(String[] args) {

    }

}
