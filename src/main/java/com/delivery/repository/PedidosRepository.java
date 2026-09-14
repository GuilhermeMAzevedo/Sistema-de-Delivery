package com.delivery.repository;

import com.delivery.datastructure.ListaEncadeadaDupla;
import com.delivery.model.Cliente;
import com.delivery.model.Pedido;

public class PedidosRepository {
    private ListaEncadeadaDupla<Pedido> pedidos = new ListaEncadeadaDupla<>();

    public void salvar(Pedido pedido){
        pedidos.inserirFinal(pedido);
    }

    public Pedido buscarPorId(String id){
        for (Pedido pedido : pedidos){
            if (pedido.getId().equals(id)){
                return pedido;
            }
        }
        return null;
    }

    public ListaEncadeadaDupla<Pedido> consultarPedidos(Cliente cliente){
        ListaEncadeadaDupla<Pedido> resultado = new ListaEncadeadaDupla<>();
        for (Pedido pedido : pedidos){
            if (pedido.getCliente().equals(cliente)){
                resultado.inserirFinal(pedido);
            }
        }
        return resultado;
    }
}
