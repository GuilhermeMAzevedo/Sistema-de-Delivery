# Sistema de Delivery
>Projeto acadêmico da disciplina de Projeto de Arquitetura de Sistemas — Ciência da Computação, UNIFOR

## Sobre o Projeto

Este projeto modela e implementa um sistema de delivery (pedidos, pagamentos, entregas e notificações), com foco em aplicar de forma intencional os **princípios SOLID** e os **padrões GRASP** na arquitetura orientada a objetos, desde a fase de modelagem em UML até a implementação em código.

A atividade não teve um enunciado fechado: o tema (sistema de delivery) e o escopo das funcionalidades foram definidos livremente, com o objetivo de pensar a arquitetura do sistema — não apenas fazê-lo funcionar.

## Diagrama de Classe

<img width="1764" height="721" alt="Captura de tela 2026-09-16 183347" src="https://github.com/user-attachments/assets/0d2261a6-83ce-4453-8f8c-69ebbf2ecbd3" />



## Princípios de Projeto Aplicados

### SOLID
| Princípio | Onde é aplicado |
|---|---|
| **SRP** | `GerenciadorClientes`, `GerenciadorRestaurantes` e `PedidosRepository` isolam responsabilidades que antes estariam concentradas em uma única classe administradora. |
| **OCP** | `Promocao` (abstrata), `PagamentoStrategy` e `NotificacaoService` permitem adicionar novos tipos de promoção, pagamento ou notificação sem alterar código existente. |
| **LSP** | Todas as implementações de `PagamentoStrategy` respeitam o mesmo contrato (`processar(valor: double): boolean`), podendo substituir umas às outras livremente. |
| **ISP** | `Pedido` expõe apenas as operações que lhe dizem respeito (`confirmar()`, `cancelar()`); consultas e persistência ficam isoladas em `PedidosRepository`. |
| **DIP** | Classes de alto nível (`CheckoutService`, `Pagamento`, `NotificadorPedido`) dependem de abstrações (`Promocao`, `PagamentoStrategy`, `NotificacaoService`), nunca de implementações concretas. |

### GRASP
| Padrão | Onde é aplicado |
|---|---|
| **Information Expert** | `Carrinho.calcularTotal()` — quem tem os dados calcula. |
| **Creator** | `CheckoutService` cria `Pedido` a partir de `Carrinho` e `Cliente`. |
| **Controller** | `CheckoutService`, `GerenciadorClientes`, `GerenciadorRestaurantes`. |
| **Low Coupling / High Cohesion** | Dependências por interface; classes com responsabilidade única e bem definida. |
| **Polymorphism** | Variações de pagamento e notificação resolvidas por tipo, sem `if/else`. |
| **Pure Fabrication** | `PedidosRepository`, `NotificadorPedido`, `GerenciadorClientes`, `GerenciadorRestaurantes`. |
| **Indirection** | `NotificadorPedido` medeia `Pedido` e `NotificacaoService`. |
| **Protected Variations** | `Promocao`, `PagamentoStrategy` e `NotificacaoService` isolam o restante do sistema de mudanças em suas variações. |

## Tecnologias

- **Java 17**
- **Maven** — build e gerenciamento de dependências
- **JUnit 5** — testes unitários
- *(opcional)* **MySQL** — persistência real, caso implementada além da versão em memória

### Estrutura do Projeto (planejada)
```
src/main/java/com/delivery/
├──model/           # Cliente, Restaurante, Produto, Endereco, Carrinho, ItemCarrinho...
├── enums/           # StatusPedido, StatusEntrega, StatusPagamento
├── promocao/        # Promocao (abstrata) e subclasses
├── pagamento/       # PagamentoStrategy e implementações
├── notificacao/     # NotificacaoService e implementações
├── repository/      # PedidosRepository
├── service/         # CheckoutService, GerenciadorClientes, GerenciadorRestaurantes, NotificadorPedido
└── Main.java        # Classe de demonstração
```

## Funcionalidades

- Cadastro e gestão de clientes e restaurantes
- Montagem de carrinho e cálculo de total (aplicação de promoções)
- Finalização de compra e criação de pedido
- Processamento de pagamento (dinheiro, cartão ou pix)
- Acompanhamento de status do pedido e da entrega
- Rastreiamento de posição de entrega (GPS)
- Notificação d o cliente por Push, SMS ou e-mail
- Geração relatórios administrativos (vendas e entregas)

## Como executar
> Em desenvolvimento — instruções de build/execução serão adicionadas conforme a implementação avança.

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.delivery.Main"
```

## Autor
- **Guilherme Azevedo**
- Disciplina: Projeto de Arquitetura de Sistemas - Prof. Ronaldo Pinheiro
