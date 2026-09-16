package com.delivery.notificacao;

public class NotificacaoEmail implements NotificacaoService {
    @Override
    public void enviar(String email, String mensagem) {
        System.out.println("[EMAIL] Para " + email + ": " + mensagem);
    }
}
