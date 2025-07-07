package com.example.demo.repository.orm;

public record PedidoOrm(
    String id,
    String nome,
    String produto,
    String userId,
    String status
) {
}