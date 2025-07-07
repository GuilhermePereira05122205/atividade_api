package com.example.entities;

public record Pedido(
    String id,
    String nome,
    String produto,
    String userId,
    String status,
    double frete
){}