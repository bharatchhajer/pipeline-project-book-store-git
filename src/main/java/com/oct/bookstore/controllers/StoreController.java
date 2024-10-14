package com.oct.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oct.bookstore.domain.store.Store;
import com.oct.bookstore.services.StoreService;
import com.oct.bookstore.repositories.*;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    //@Autowired
   // private StoreService storeService;
    
    @Autowired
    private StoreRepository storeRepository;

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
      //  storeService.saveStoreWithDetail(store);
        return ResponseEntity.ok(store);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
       // Store store = storeService.findStoreById(id);
    	Store store = storeRepository.findById(id);
        return store != null ? ResponseEntity.ok(store) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
    //    storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }
}
