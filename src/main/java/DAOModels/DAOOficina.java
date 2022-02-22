package DAOModels;

import VOModels.Oficinas;
import conexion.Conexion;

public class DAOOficina {

    public Oficinas findOficina(int idOficina) {
        Conexion conn = new Conexion();
        return conn.getConexion().find(Oficinas.class,idOficina);
    }
}
