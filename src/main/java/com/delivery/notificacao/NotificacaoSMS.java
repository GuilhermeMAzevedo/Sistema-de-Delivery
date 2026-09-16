package com.delivery.notificacao;

public class NotificacaoSMS implements NotificacaoService {
    @Override
    public void enviar(String telefone, String mensagem) {
        System.out.println("[SMS] Para " + telefone + ": " + mensagem);
    }
}
