package conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager  entityManager;

    public Conexion() {
        entityManagerFactory = Persistence.createEntityManagerFactory("UD03BDAlquilerVehiculos");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManager getConexion() {
        return entityManager;
    }

    public static void desconectar() {
        entityManager.close();
        entityManagerFactory.close();
    }

}

