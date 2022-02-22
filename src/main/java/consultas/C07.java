package consultas;

import DAOModels.DAOVehiculos;

import java.util.Iterator;

public class C07 {

    public DAOVehiculos v = new DAOVehiculos();

    public void getPuertasMaletero() {
        Iterator it = v.getPuertasMaletero();
        while (it.hasNext()){
            Object[]row = (Object[]) it.next();
            System.out.println("Matricula: " + row[0] + "\nMarca: " + row[1] + "\nMaletero: " + row[5] + "\nPuertas: " + row[4]);
        }
    }

    public static void main(String[] args) {
        C07 c07 = new C07();
        c07.getPuertasMaletero();
    }
}
