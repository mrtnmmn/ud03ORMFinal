package DAOModels;

import VOModels.VehiculoClientes;
import VOModels.Vehiculos;
import conexion.Conexion;

import javax.persistence.PersistenceException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DAOVehiculoClientes {

    // Ej04
    public Iterator getAlquileresMatricula() {

        Scanner ns = new Scanner(System.in);

        System.out.print("Introducir matricula a buscar: ");
        String matricula = ns.nextLine();

        //String hql = "SELECT c.nombre, v.matricula, v.marca, vc.dias, vc.seguro, vc.precio from Vehiculos v join VehiculoCliente vc on v.matricula = vc.vehiculo" +
                //" join Cliente c on c.dni = vc.cliente where v.matricula = :matricula";

        String hql = "SELECT cl.nombre, v.matricula, v.marca, vc.dias, vc.seguro, vc.precio " +
                "FROM Clientes cl JOIN VehiculoClientes vc ON cl.dni = vc.cliente " +
                "JOIN Vehiculos v ON vc.vehiculo = v.matricula WHERE v.matricula=:matricula";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).setParameter("matricula", matricula).getResultList().iterator();


    }

    // Ej06
    public Iterator getAlquileresOrder() {


        String hql = "SELECT v.matricula, c.dni, c.nombre, c.telefono, vc.dias, vc.precio from VehiculoClientes vc join Clientes c on c.dni = vc.cliente join Vehiculos v on v.matricula = vc.vehiculo " +
                " order by c.nombre, v.matricula";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList().iterator();
    }

    // Ej09
    public List<VehiculoClientes> getCostesAltos() {

        String hql = "from VehiculoClientes vc order by vc.precio";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList();
    }

    //Ej05 insertar alquiler
    public void insertAlquiler(VehiculoClientes vc){
        Conexion conn = new Conexion();

        try {
            conn.getConexion().getTransaction().begin();
            conn.getConexion().merge(vc);
            conn.getConexion().getTransaction().commit();
        } catch (PersistenceException e) {
            conn.getConexion().getTransaction().rollback();
            e.printStackTrace();
        }
    }


}
