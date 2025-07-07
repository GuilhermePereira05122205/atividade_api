package com.example.demo.controller.DTO;

import com.example.entities.User;

public record PedidoRequest(
    String id,
    String nome,
    String produto,
    String userId,
    String frete
) {

}