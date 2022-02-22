package DAOModels;

import VOModels.Vehiculos;
import conexion.Conexion;
import utils.Connections;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DAOVehiculos {

    // Ej01
    public List<Vehiculos> getListVehiculoGroups(){

        String hql = "FROM Vehiculos v WHERE v.grupo = 'E' OR  v.grupo = 'F' OR v.grupo = 'G'";
        //return Connections.getList(hql);
        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList();

    }

    // Ej02
    public Iterator getListPrecioYDias(){
        String hql = "SELECT SUM(vc.dias), SUM(vc.precio), v.matricula FROM Vehiculos v JOIN VehiculoCliente vc ON v.matricula = vc.vehiculo GROUP BY v.matricula";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList().iterator();
    }

    // Ej03
    public Iterator getNoAlquilados() {
        String hql = "select v.matricula from VehiculoCliente vc join Vehiculos v on v.matricula = vc.vehiculo where vc.dias = 0";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList().iterator();
    }

    // Ej07
    public Iterator getPuertasMaletero() {

        Scanner ns = new Scanner(System.in);

        System.out.print("Introducir el maletero: ");
        int maletero = ns.nextInt();

        System.out.print("\nIntroducir puertas");
        int puertas = ns.nextInt();

        System.out.println("");

        String hql = "from Vehiculos v where v.maletero > " + maletero + " and v.puertas = " + puertas;



        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList().iterator();
    }

}

