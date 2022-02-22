package consultas;

import DAOModels.DAOOficina;
import DAOModels.DAOVehiculos;
import VOModels.Vehiculos;
import conexion.Conexion;

import java.util.Scanner;

public class C05 {

    public Scanner ns = new Scanner(System.in);
    public DAOVehiculos v = new DAOVehiculos();
    public DAOOficina o = new DAOOficina();

    public void insertAlquiler() {
        System.out.println("Insertando un alquiler :");
        System.out.print("\tInsertar la matricula del vehiculo (si no existiera se iniciara el proceso de insercion de un nuevo coche: ");

        String matricula = ns.nextLine();
        Vehiculos vFinal;
        if (v.comprobarMatricula(matricula).isEmpty()) {
            vFinal = insertNewVehiculo(matricula);
        } else {
            vFinal = v.getVehiculo(matricula);
        }




    }

    public Vehiculos insertNewVehiculo(String matricula) {

        Vehiculos v1 = new Vehiculos();

        v1.setMatricula(matricula);

        System.out.println("Creando un nuevo vehiculo con matricula " + matricula + ": ");
        System.out.print("\tInsertar marca: ");
        v1.setMarca(ns.nextLine());
        System.out.print("\tInsertar grupo: ");
        v1.setGrupo(Vehiculos.Grupo.valueOf(ns.nextLine()));
        System.out.print("\tInsertar plazas: ");
        v1.setPlazas(ns.nextInt());
        System.out.print("\tInsertar maletero: ");
        v1.setMaletero(ns.nextInt());
        System.out.print("\tInsertar edad: ");
        v1.setEdad(ns.nextInt());
        System.out.print("\tInsertar codigo de oficina: ");
        v1.setOficina(o.findOficina(ns.nextInt()));

        v.insertVehiculo(v1);

        return v1;

    }


    public static void main(String[] args) {
        C05 c05 = new C05();
        c05.insertAlquiler();
    }
}
