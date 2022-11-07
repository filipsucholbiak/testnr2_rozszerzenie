package pl.kurs.equationsolver.dao;

import pl.kurs.equationsolver.model.SolvingEvent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class SolvingEventDao implements ISolvingEventDao {

    @PersistenceUnit
    private EntityManagerFactory factory;

    @Override
    public void save(SolvingEvent solvingEvent) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(solvingEvent);
        tx.commit();
        entityManager.close();
    }
}
