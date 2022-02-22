package DAOModels;

import VOModels.Vehiculos;
import conexion.Conexion;
import utils.Connections;

import java.util.Iterator;
import java.util.List;

public class DAOVehiculos {

    // Ej01
    public List<Vehiculos> getListVehiculoGroups(){

        String hql = "FROM Vehiculos v WHERE v.grupo = 'E' OR  v.grupo = 'F' OR v.grupo = 'G'";
        //return Connections.getList(hql);
        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList();

    }

    // Ej02
    public Iterator getListPrecioYDias() {
        String hql = "select sum(vcDias), sum(cvPrecio), vcMatricula from "
    }


}

