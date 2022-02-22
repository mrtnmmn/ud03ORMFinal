package DAOModels;

import VOModels.Clientes;
import conexion.Conexion;

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


}
