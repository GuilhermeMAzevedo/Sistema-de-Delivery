package com.delivery.service;

import com.delivery.enums.StatusEntrega;
import com.delivery.model.Entrega;
import com.delivery.model.Relatorio;
import com.delivery.model.Pedido;
import com.delivery.repository.PedidosRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dashboard {
    private PedidosRepository pedidosRepository;

    public Dashboard(PedidosRepository pedidosRepository){
        this.pedidosRepository = pedidosRepository;
    }

    public Relatorio gerarRelatorioVendas(){
        List<Pedido> pedidos = pedidosRepository.listarTodos();
        double totalVendas = 0.0;
        for (Pedido pedido : pedidos){
            totalVendas += pedido.getValorTotal();
        }
        Map<String, Object> dados = new HashMap<>();
        dados.put("totalPedidos", pedidos.size());
        dados.put("totalVendas", totalVendas);
        return new Relatorio(LocalDateTime.now(), dados);
    }

    public Relatorio gerarRelatorioEntregas(){
        List<Pedido> pedidos = pedidosRepository.listarTodos();
        int entregasFinalizadas = 0;
        for (Pedido pedido : pedidos){
            Entrega entrega = pedido.getEntrega();
            if (entrega != null && entrega.getStatus().equals(StatusEntrega.ENTREGUE)){
                entregasFinalizadas++;
            }
        }
        Map<String, Object> dados = new HashMap<>();
        dados.put("totalEntregasFinalizadas", entregasFinalizadas);
        return new Relatorio(LocalDateTime.now(), dados);
    }
}
