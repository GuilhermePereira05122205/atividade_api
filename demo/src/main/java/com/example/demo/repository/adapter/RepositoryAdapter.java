package com.example.demo.repository.adapter;

import com.example.demo.repository.orm.PedidoOrm;
import com.example.entities.Pedido;

public class RepositoryAdapter {
    public PedidoOrm cast(Pedido pedido){
        return new PedidoOrm(pedido.id(), pedido.nome(), pedido.produto(), pedido.userId(), pedido.status());
    }
}
