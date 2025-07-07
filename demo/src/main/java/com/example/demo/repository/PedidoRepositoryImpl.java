package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.calculos.CalculoPedido;
import com.example.demo.repository.client.PedidoRepositoryWithFeign;
import com.example.entities.Pedido;
import com.example.entities.User;
import com.example.integration.IntegrationInterface;
import com.example.repositories.RepositoryInterface;

@Repository
public class PedidoRepositoryImpl implements RepositoryInterface{

    private final PedidoRepositoryWithFeign repository;
    private final IntegrationInterface integration;

    public PedidoRepositoryImpl(PedidoRepositoryWithFeign pedidoRepositoryWithFeign, IntegrationInterface integration){
        this.repository = pedidoRepositoryWithFeign;
        this.integration= integration;
    }
    public Pedido save(Pedido pedido){

        User user = integration.getUser(pedido.userId());

        double preco = CalculoPedido.calcularFrete(user.city());

        return repository.save(new Pedido(
            pedido.id(),
            pedido.nome(),
            pedido.produto(),
            pedido.userId(),
            pedido.status(),
            preco
        ));
    }
    @Override
    public Pedido findById(String id) {
       Optional<Pedido> pedido = repository.findById(id);

       if(pedido.isEmpty()){
            throw new RuntimeException("Pedido não encontrado", null);
       }

       return pedido.get();

    }
    @Override
    public void delete(String id) {
       repository.deleteById(id);
    }
    
    @Override
    public List<Pedido> findAll() {
        return repository.findAll();
    }

    @Override
    public void updateStatus(String id,String status) {
        Pedido pedido = this.findById(id);
        repository.save(new Pedido(
            pedido.id(),
            pedido.nome(),
            pedido.produto(),
            pedido.userId(),
            status,
            pedido.frete()
        ));
    }
}
