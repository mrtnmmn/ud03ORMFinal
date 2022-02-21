package DAOModels;

import VOModels.Vehiculos;
import conexion.Conexion;
import utils.Connections;

import java.util.List;

public class DAOVehiculos {

    public List<Vehiculos> generateListVehiculoGroups(){
        String hql = "FROM Vehiculos v WHERE v.grupo = 'E' OR  v.grupo = 'F' OR v.grupo = 'G'";
        //return Connections.getList(hql);
        Conexion conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList();

    }



}

