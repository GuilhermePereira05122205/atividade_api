package com.example.demo.controller.DTO;

import com.example.entities.User;

public record PedidoResponse(
    String id,
    String nome,
    String produto,
    String userId,
    String status,
    double frete
) {

}
