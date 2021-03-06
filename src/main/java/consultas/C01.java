package consultas;

import DAOModels.DAOVehiculos;
import VOModels.Vehiculos;

import java.util.List;

public class C01 {
    public DAOVehiculos v = new DAOVehiculos();

    public void listGrupos() {
        System.out.println("Listando los coches pertenecientes a los grupos E, F y G");
        List<Vehiculos> listVehiculos = v.getListVehiculoGroups();
        for (Vehiculos v: listVehiculos) {
            System.out.println("Matricula:  " + v.getMatricula() + "\tGrupo: " + v.getGrupo());
        }
    }

    public static void main(String[] args) {
        C01 c01 = new C01();
        c01.listGrupos();
    }
}
