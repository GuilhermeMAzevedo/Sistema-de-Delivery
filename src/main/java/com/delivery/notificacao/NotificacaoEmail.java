package com.delivery.notificacao;

public class NotificacaoEmail implements NotificacaoService {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("[EMAIL] Para " + destinatario + ": " + mensagem);
    }
}
