package utils;

import conexion.Conexion;

import java.sql.Connection;
import java.util.List;

public class Connections {

    public Conexion conn;

    public List getList(String hql) {
        conn = new Conexion();
        return conn.getConexion().createQuery(hql).getResultList();
    }
}
