package com.example.repositories;

import java.util.List;

import com.example.entities.Pedido;

public interface RepositoryInterface {
    Pedido save(Pedido pedido);

    Pedido findById(String id);
    
    void delete(String id);

    List<Pedido> findAll();

    void updateStatus(String id,String status);
}
