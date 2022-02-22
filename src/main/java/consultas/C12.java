package consultas;

import DAOModels.DAOVehiculos;

public class C12 {

    public DAOVehiculos v = new DAOVehiculos();

    public void deleteCochePorMatricula() {
        v.deleteCochePorMatricula();
    }

    public static void main(String[] args) {
        C12 c12 = new C12();
        c12.deleteCochePorMatricula();
    }
}
