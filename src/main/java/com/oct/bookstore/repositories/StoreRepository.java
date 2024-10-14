package com.oct.bookstore.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;

import com.oct.bookstore.config.JPAConfig;
import com.oct.bookstore.config.JPAUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oct.bookstore.domain.store.Store;

@Repository
public class StoreRepository {
	public static final Logger logger = LoggerFactory.getLogger(StoreRepository.class);
	
	@Autowired
    private EntityManager entityManager;

    public void save(Store store) {
		entityManager.persist(store);      
    }

    public Store findById(Long id) {
		Store store = entityManager.find(Store.class, id);
        return store;
    }

    public void delete(Long id) {
        Store store = findById(id);
        if (store != null) {
            entityManager.remove(store);
        }
    }
}
