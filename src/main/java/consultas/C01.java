package consultas;

import DAOModels.DAOVehiculos;
import VOModels.Vehiculos;

import java.util.List;

public class C01 {

    public DAOVehiculos v = new DAOVehiculos();

    public void ListGrupos() {
        List<Vehiculos> listVehiculos = v.generateListVehiculoGroups();
    }

    public static void main(String[] args) {

    }

}
