package DAOModels;

import VOModels.Vehiculos;
import conexion.Conexion;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DAOVehiculos {

    public Scanner ns = new Scanner(System.in);

    // Ej01
    public List<Vehiculos> getListVehiculoGroups(){

        String hql = "FROM Vehiculos v WHERE v.grupo = 'E' OR  v.grupo = 'F' OR v.grupo = 'G'";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList();

    }

    // Ej02
    public Iterator getListPrecioYDias(){
        String hql = "SELECT SUM(vc.dias), SUM(vc.precio), v.matricula FROM Vehiculos v JOIN VehiculoClientes vc ON v.matricula = vc.vehiculo GROUP BY v.matricula";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList().iterator();
    }

    // Ej03
    public Iterator getNoAlquilados() {
        String hql = "select v.matricula from VehiculoClientes vc join Vehiculos v on v.matricula = vc.vehiculo where vc.dias = 0";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList().iterator();
    }

    // Ej07
    public List<Vehiculos> getPuertasMaletero() {


        System.out.print("Introducir el maletero: ");
        int maletero = ns.nextInt();

        System.out.print("Introducir puertas: ");
        int puertas = ns.nextInt();

        System.out.println("");

        String hql = "from Vehiculos v where v.maletero > " + maletero + " and v.puertas = " + puertas;



        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList();
    }

    // EJ10
    public List<Vehiculos> getLetrasMatricula() {

        System.out.print("Insertar letrs de la matricula: ");
        String letras = ns.nextLine();

        String hql = "from Vehiculos v where SUBSTRING(v.matricula, 1,3) = :letras";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).setParameter("letras", letras).getResultList();
    }

    //Ej12
    public void deleteCochePorMatricula() {

        System.out.print("Insertar la matricula del coche a borrar: ");
        String matricula = ns.nextLine();

        String hql01 = "DELETE FROM VehiculoClientes vc where vc.vehiculo.matricula = :matricula";
        String hql02 = "DELETE FROM Vehiculos v where v.matricula = :matricula";

        Conexion conn = new Conexion();

        try {
            conn.getConexion().getTransaction().begin();

            Query q01 = conn.getConexion().createQuery(hql01);
            q01.setParameter("matricula", matricula).executeUpdate();
            Query q02 = conn.getConexion().createQuery(hql02);
            q02.setParameter("matricula", matricula).executeUpdate();

            conn.getConexion().getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            conn.getConexion().getTransaction().rollback();
        }
    }

    //Ej05 comprobacion matricula
    public List<Vehiculos> comprobarMatricula(String matricula) {

        String hql = "FROM Vehiculos v where v.matricula = :matricula";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).setParameter("matricula", matricula).getResultList();
    }

    //Ej05 obtener vehiculo
    public Vehiculos getVehiculo(String matricula) {
        Conexion conn = new Conexion();
        return conn.getConexion().find(Vehiculos.class,matricula);
    }

    //ej05 Insertar vehiculo
    public void insertVehiculo(Vehiculos v) {
        Conexion conn = new Conexion();

        try {
            conn.getConexion().getTransaction().begin();
            conn.getConexion().merge(v);
            conn.getConexion().getTransaction().commit();
        } catch (PersistenceException e) {
            conn.getConexion().getTransaction().rollback();
            e.printStackTrace();
        }
    }

}