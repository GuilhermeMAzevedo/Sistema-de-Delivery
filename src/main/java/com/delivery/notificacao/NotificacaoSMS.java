package com.delivery.notificacao;

public class NotificacaoSMS implements NotificacaoService {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("[SMS] Para " + destinatario + ": " + mensagem);
    }
}
