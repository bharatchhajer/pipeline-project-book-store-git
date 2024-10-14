package com.oct.bookstore.services;

import com.oct.bookstore.domain.store.Store;
import com.oct.bookstore.domain.store.StoreDetail;

import com.oct.bookstore.repositories.StoreRepository;
import com.oct.bookstore.repositories.StoreDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeDAO;

    @Autowired
    private StoreDetailRepository storeDetailDAO;

    public void saveStoreWithDetail(Store store) {
        storeDAO.save(store);  // storeDetail will be saved automatically due to CascadeType.ALL
    }

    public Store findStoreById(Long id) {
        return storeDAO.findById(id);
    }

    public StoreDetail findStoreDetailById(Long id) {
        return storeDetailDAO.findById(id);
    }

    public void deleteStore(Long id) {
        storeDAO.delete(id);
    }

    public void deleteStoreDetail(Long id) {
        storeDetailDAO.delete(id);
    }
}
