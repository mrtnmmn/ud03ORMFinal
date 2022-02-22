package DAOModels;

import VOModels.Clientes;
import VOModels.Vehiculos;
import conexion.Conexion;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Scanner;

public class DAOCliente {

    public Scanner ns = new Scanner(System.in);

    public List<Clientes> getClientesLetra() {
        System.out.print("Introducir la letra a buscar: ");
        String letra = ns.nextLine();

        String hql = "FROM Clientes c where SUBSTRING(SUBSTRING_INDEX(c.nombre, ' ', -1), 1, 1) = :letra";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).setParameter("letra", letra).getResultList();
    }

    //ej05 Insertar cliente
    public void insertCliente(Clientes c) {
        Conexion conn = new Conexion();

        try {
            conn.getConexion().getTransaction().begin();
            conn.getConexion().merge(c);
            conn.getConexion().getTransaction().commit();
        } catch (PersistenceException e) {
            conn.getConexion().getTransaction().rollback();
            e.printStackTrace();
        }
    }

    //Ej05 comprobacion cliente
    public List<Clientes> comprobarDNI(String dni) {

        String hql = "FROM Clientes c where c.dni = :dni";

        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).setParameter("dni", dni).getResultList();
    }

    //Ej05 obtener vehiculo
    public Clientes getCliente(String dni) {
        Conexion conn = new Conexion();
        return conn.getConexion().find(Clientes.class,dni);
    }


}
