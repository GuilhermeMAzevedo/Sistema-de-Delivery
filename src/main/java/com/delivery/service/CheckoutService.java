package com.delivery.service;

import com.delivery.model.Carrinho;
import com.delivery.model.Cliente;
import com.delivery.model.Pedido;
import com.delivery.promocao.Promocao;
import com.delivery.repository.PedidosRepository;

import java.util.UUID;

public class CheckoutService {
    private PedidosRepository pedidosRepository;

    public CheckoutService(PedidosRepository pedidosRepository){
        this.pedidosRepository = pedidosRepository;
    }

    public Pedido finalizarCompra(Carrinho carrinho, Cliente cliente){
        double valorTotal = carrinho.calcularTotal();
        Pedido pedido = new Pedido(UUID.randomUUID().toString(), cliente, valorTotal);
        pedidosRepository.salvar(pedido);
        return pedido;
    }

    public Pedido finalizarCompra(Carrinho carrinho, Cliente cliente, Promocao promocao){
        double valorTotal = (promocao != null && promocao.isValida()) ? promocao.aplicar(carrinho) : carrinho.calcularTotal();
        Pedido pedido = new Pedido(UUID.randomUUID().toString(), cliente, valorTotal);
        pedidosRepository.salvar(pedido);
        return pedido;
    }
}
