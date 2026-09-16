package com.delivery.notificacao;

public class NotificacaoPush implements NotificacaoService {
    @Override
    public void enviar(String token, String mensagem) {
        System.out.println("[PUSH] Para token " + token + ": " + mensagem);
    }
}
