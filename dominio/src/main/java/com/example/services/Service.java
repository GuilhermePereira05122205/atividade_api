package com.example.services;

import com.example.entities.Pedido;
import com.example.repositories.RepositoryInterface;

public class Service {
    RepositoryInterface repository;

    public Service(RepositoryInterface repository){
        this.repository = repository;
    }

    public Pedido save(Pedido pedido){
        return new Pedido();
    }
}
