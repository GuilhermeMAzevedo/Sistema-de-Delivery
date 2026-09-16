package com.delivery;

import com.delivery.model.*;
import com.delivery.notificacao.NotificacaoEmail;
import com.delivery.notificacao.NotificacaoService;
import com.delivery.pagamento.Pagamento;
import com.delivery.pagamento.PagamentoPix;
import com.delivery.promocao.Promocao;
import com.delivery.promocao.PromocaoPercentual;
import com.delivery.repository.ClientesRepository;
import com.delivery.repository.PedidosRepository;
import com.delivery.repository.RestaurantesRepository;
import com.delivery.service.CheckoutService;
import com.delivery.service.GerenciadorClientes;
import com.delivery.service.GerenciadorRestaurantes;
import com.delivery.service.NotificadorPedidos;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // 1. Infraestrutura: repositórios e services
        PedidosRepository pedidosRepository = new PedidosRepository();
        ClientesRepository clientesRepository = new ClientesRepository();
        RestaurantesRepository restaurantesRepository = new RestaurantesRepository();

        CheckoutService checkoutService = new CheckoutService(pedidosRepository);
        GerenciadorClientes gerenciadorClientes = new GerenciadorClientes(clientesRepository);
        GerenciadorRestaurantes gerenciadorRestaurantes = new GerenciadorRestaurantes(restaurantesRepository);

        NotificacaoService notificacaoService = new NotificacaoEmail();
        NotificadorPedidos notificadorPedidos = new NotificadorPedidos(notificacaoService);

        // 2. Cadastro de restaurante e produtos (fluxo administrativo)
        Restaurante restaurante = new Restaurante("rest-1", "Pizzaria Bella", "12.345.678/0001-99");
        Produto pizza = new Produto("prod-1", "Pizza Margherita", 45.0);
        Produto refrigerante = new Produto("prod-2", "Refrigerante Lata", 6.0);
        restaurante.adicionarProduto(pizza);
        restaurante.adicionarProduto(refrigerante);
        gerenciadorRestaurantes.cadastrarRestaurante(restaurante);

        // 3. Cadastro do cliente (auto-cadastro, fora do fluxo do admin)
        Cliente cliente = new Cliente("cli-1", "Guilherme", "guilherme@email.com", "85999999999");
        clientesRepository.salvar(cliente);
        System.out.println("Clientes cadastrados (visão do admin): " + gerenciadorClientes.getClienteRepository().listarTodos().getQuantidadeDados());

        // 4. Montagem do carrinho
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarAoCarrinho(pizza, 2);
        carrinho.adicionarAoCarrinho(refrigerante, 1);
        carrinho.adicionarAoCarrinho(pizza, 1); // testa o incremento em vez de duplicar item
        System.out.println("Total sem promoção: R$ " + carrinho.calcularTotal());

        // 5. Promoção
        Promocao promocao = new PromocaoPercentual("PROMO10", LocalDateTime.now().plusDays(1), 10.0);

        // 6. Finalização da compra
        Pedido pedido = checkoutService.finalizarCompra(carrinho, cliente, promocao);
        System.out.println("Pedido criado: " + pedido.getId()
                + " | Total com desconto: R$ " + pedido.getValorTotal()
                + " | Status: " + pedido.getStatus());

        // 7. Pagamento
        Pagamento pagamento = new Pagamento(pedido.getValorTotal(), new PagamentoPix());
        boolean pagamentoAprovado = pagamento.executar();
        pedido.definirPagamento(pagamento);
        System.out.println("Pagamento aprovado? " + pagamentoAprovado + " | Status: " + pagamento.getStatus());

        if (pagamentoAprovado) {
            pedido.confirmar();
            notificadorPedidos.notificarStatus(pedido);
        }

        // 8. Entrega
        Entrega entrega = new Entrega("entrega-1", "Rua das Flores, 123");
        pedido.definirEntrega(entrega);

        Entregador entregador = new Entregador("entregador-1", "Carlos", "Moto");
        entrega.atribuirEntregador(entregador);
        entrega.iniciar();

        entrega.getRastreamento().atualizarPosicao(new PosicaoGPS(-3.7327, -38.5267));
        entrega.getRastreamento().atualizarPosicao(new PosicaoGPS(-3.7350, -38.5300));

        entrega.finalizar();
        notificadorPedidos.notificarStatus(pedido);

        System.out.println("Entrega " + entrega.getId()
                + " | Status: " + entrega.getStatus()
                + " | Posições registradas: " + entrega.getRastreamento().getHistorico().toArray().length);

        // 9. Consulta de pedidos do cliente
        System.out.println("Pedidos do cliente " + cliente.getNome() + ": "
                + pedidosRepository.consultarPedidos(cliente).toArray().length);
    }
}