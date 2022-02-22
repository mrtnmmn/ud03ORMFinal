package consultas;

import DAOModels.DAOVehiculos;
import VOModels.Vehiculos;

import java.util.List;

public class C10 {

    public DAOVehiculos v = new DAOVehiculos();

    public void getLetrasMatricula() {
        List<Vehiculos> vehiculosList = v.getLetrasMatricula();

        for (Vehiculos v: vehiculosList) {
            System.out.println(v.getMatricula());
        }
    }

    public static void main(String[] args) {
        C10 c10 = new C10();
        c10.getLetrasMatricula();
    }
}
