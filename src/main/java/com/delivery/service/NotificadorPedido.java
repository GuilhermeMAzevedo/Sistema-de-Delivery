package com.delivery.service;

import com.delivery.model.Pedido;
import com.delivery.notificacao.NotificacaoService;

public class NotificadorPedido {
    private NotificacaoService notificacaoService;

    public NotificadorPedido(NotificacaoService notificacaoService){
        this.notificacaoService = notificacaoService;
    }

    public void notificarStatus(Pedido pedido){
        String mensagem = "Seu pedido " + pedido.getId() + " está " + pedido.getStatus();

        notificacaoService.enviar(pedido.getCliente().getEmail(), mensagem);
    }
}
