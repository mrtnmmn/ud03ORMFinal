package DAOModels;

import conexion.Conexion;

import java.util.Iterator;
import java.util.Scanner;

public class DAOVehiculoClientes {

    // Ej04
    public Iterator getAlquileresMatricula() {

        Scanner ns = new Scanner(System.in);

        System.out.print("Introducir matricula a buscar: ");
        String matricula = ns.nextLine();

        String hql = "SELECT c.nombre, v.matricula, v.marca, vc.dias, vc.seguro, vc.precio from Vehiculos v join VehiculoCliente vc on v.matricula = vc.vehiculo" +
                " join Cliente c on c.dni = vc.cliente where v.matricula = " + matricula;

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList().iterator();
    }

    // Ej06
    public Iterator getAlquileresOrder() {


        String hql = "SELECT v.matricula, c.dni, c.nombre, c.telefono, vc.dias, vc.precio from VehiculoCliente vc join Cliente c on c.dni = vc.cliente join Vehiculos v on v.matricula = vc.vehiculo " +
                " order by c.nombre, v.matricula";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList().iterator();
    }


}
