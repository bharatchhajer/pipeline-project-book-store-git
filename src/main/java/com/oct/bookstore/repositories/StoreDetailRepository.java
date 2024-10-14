package com.oct.bookstore.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oct.bookstore.domain.store.StoreDetail;

@Repository
public class StoreDetailRepository {


    private EntityManager entityManager;

    public void save(StoreDetail storeDetail) {
        entityManager.persist(storeDetail);
    }

    public StoreDetail findById(Long id) {
        return entityManager.find(StoreDetail.class, id);
    }

    public void delete(Long id) {
        StoreDetail storeDetail = findById(id);
        if (storeDetail != null) {
            entityManager.remove(storeDetail);
        }
    }
}