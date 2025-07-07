package com.example.demo.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.DTO.PedidoRequest;
import com.example.demo.controller.DTO.PedidoResponse;
import com.example.demo.controller.adapters.PedidoControllerAdapter;
import com.example.entities.Pedido;
import com.example.repositories.RepositoryInterface;

@RestController
@RequestMapping("/frete/v1/pedido")
public class FreteController {

    final RepositoryInterface repository;

    public FreteController(RepositoryInterface repository){
        this.repository = repository;
    }

    @GetMapping
    public List<PedidoResponse> getAll(){
        return PedidoControllerAdapter.cast(repository.findAll());
    }

    @PostMapping
    public PedidoResponse save(@RequestBody PedidoRequest request){
        Pedido pedido = PedidoControllerAdapter.cast(request);
        return PedidoControllerAdapter.cast(repository.save(pedido));
    }
    

    @GetMapping("{id}")
    public PedidoResponse getById(@PathVariable String id){
        return PedidoControllerAdapter.cast(repository.findById(id));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        repository.delete(id);
    }

    @PutMapping("{id}/{status}")
    public void updateStatus(@PathVariable String id, @PathVariable String status){
        repository.updateStatus(id, status);
    }
}