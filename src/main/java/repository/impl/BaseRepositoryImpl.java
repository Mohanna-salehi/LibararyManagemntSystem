package repository.impl;


import jakarta.persistence.Entity;
import repository.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import model.BaseEntity;
import util.EntityManagerProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<ID, TYPE extends BaseEntity<ID>> implements BaseRepository<ID, TYPE> {


    @Override
    public TYPE saveOrUpdate(TYPE type) {
        EntityManager em = EntityManagerProvider.entityManager.get();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            if (type.getId() == null) {
                em.persist(type);
            } else {
                em.merge(type);
            }
            transaction.commit();
            return type;

        } catch (PersistenceException p) {
            transaction.rollback();
            throw new PersistenceException("saving failed " + p.getMessage());

        } finally {
            em.close();
        }
    }


    @Override
    public boolean deleteById(ID id) {
        EntityManager em = EntityManagerProvider.entityManager.get();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            TYPE entity = em.find(getEntityClass(), id);
            if (entity == null) {
                return false;
            }
            em.remove(entity);
            transaction.commit();
            return true;


        } catch (PersistenceException p) {
            transaction.rollback();
            throw new PersistenceException("deleting failed " + p.getMessage());

        } finally {
            em.close();
        }
    }


    @Override
    public Optional<TYPE> findById(ID id) {
        return Optional.ofNullable(
                EntityManagerProvider
                        .entityManager
                        .get()
                        .find(getEntityClass(), id)
        );

    }

    @Override
    public List<TYPE> findAll() {
        return EntityManagerProvider
                .entityManager
                .get()
                .createQuery("from " + getEntityClass().getName(), getEntityClass()).getResultList();

    }
}
