package com.delivery.repository;

import com.delivery.model.Cliente;
import com.delivery.model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidosRepository {
    private List<Pedido> pedidos = new ArrayList<>();

    public void salvar(Pedido pedido){
        pedidos.add(pedido);
    }

    public Pedido buscarPorId(String id){
        for (Pedido pedido : pedidos){
            if (pedido.getId().equals(id)){
                return pedido;
            }
        }
        return null;
    }

    public List<Pedido> listarTodos(){
        return List.copyOf(pedidos);
    }

    public List<Pedido> consultarPedidos(Cliente cliente){
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos){
            if (pedido.getCliente().equals(cliente)){
                resultado.add(pedido);
            }
        }
        return List.copyOf(resultado);
    }
}
