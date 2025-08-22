package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.function.Supplier;

public class EntityManagerProvider {

    static EntityManagerFactory emf = null;

    public static Supplier<EntityManager> entityManager = () -> {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("default");
        }
        return emf.createEntityManager();
    };
}
