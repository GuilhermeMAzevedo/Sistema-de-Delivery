package com.delivery.service;

import com.delivery.datastructure.ListaEncadeadaDupla;
import com.delivery.model.Cliente;
import com.delivery.repository.ClienteRepository;

public class GerenciadorClientes {
    private ClienteRepository clienteRepository;

    public GerenciadorClientes(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public ClienteRepository getClienteRepository() {
        return clienteRepository;
    }

    public Cliente buscarClientePorId(String id){
        return clienteRepository.buscarPorId(id);
    }

    public void excluirCliente(String id){
        clienteRepository.excluirPorId(id);
    }
}
