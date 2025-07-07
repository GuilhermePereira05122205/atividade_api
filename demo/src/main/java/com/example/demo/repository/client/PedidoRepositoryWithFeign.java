package com.example.demo.repository.client;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Pedido;

@Repository
public interface PedidoRepositoryWithFeign extends MongoRepository<Pedido, String>{

    
}