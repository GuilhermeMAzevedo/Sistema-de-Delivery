package com.delivery.notificacao;

public class NotificacaoPush implements NotificacaoService {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("[PUSH] Para token " + destinatario + ": " + mensagem);
    }
}
