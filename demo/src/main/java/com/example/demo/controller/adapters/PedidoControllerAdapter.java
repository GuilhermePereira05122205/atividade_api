package com.example.demo.controller.adapters;

import java.util.List;
import java.util.UUID;

import com.example.demo.controller.DTO.PedidoRequest;
import com.example.demo.controller.DTO.PedidoResponse;
import com.example.entities.Pedido;

public class PedidoControllerAdapter {
    public static Pedido cast(PedidoRequest pedido){
        return new Pedido(
            UUID.randomUUID().toString(), 
            pedido.nome(), 
            pedido.produto(),
            pedido.userId(),
            pedido.frete(),
            -1);
    }

    public static PedidoResponse cast(Pedido pedido){
        return new PedidoResponse(
            pedido.id(),
            pedido.nome(), 
            pedido.produto(),
            pedido.userId(),
            pedido.status(),
            pedido.frete());
    }

     public static List<PedidoResponse> cast(List<Pedido> pedido){
        return pedido.stream().map((Pedido p) -> {
            return new PedidoResponse(
                p.id(),
                p.nome(), 
                p.produto(),
                p.userId(),
                p.status(),
                p.frete());
        }).toList();
    }
    
}