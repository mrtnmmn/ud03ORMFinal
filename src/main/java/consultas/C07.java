package consultas;

import DAOModels.DAOVehiculos;
import VOModels.Vehiculos;

import java.util.Iterator;
import java.util.List;

public class C07 {

    public DAOVehiculos v = new DAOVehiculos();

    public void getPuertasMaletero() {
        List<Vehiculos> vehiculos = v.getPuertasMaletero();
        for (Vehiculos v: vehiculos) {
            System.out.println(v.getMatricula() );
        }
    }

    public static void main(String[] args) {
        C07 c07 = new C07();
        c07.getPuertasMaletero();
    }
}