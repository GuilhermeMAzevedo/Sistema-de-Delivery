package com.delivery.service;

import com.delivery.model.Cliente;
import com.delivery.repository.ClientesRepository;

import java.util.List;

public class GerenciadorClientes {
    private ClientesRepository clientesRepository;

    public GerenciadorClientes(ClientesRepository clientesRepository){
        this.clientesRepository = clientesRepository;
    }

    public List<Cliente> listarClientes(){
        return clientesRepository.listarTodos();
    }

    public Cliente buscarClientePorId(String id){
        return clientesRepository.buscarPorId(id);
    }

    public void excluirCliente(String id){
        clientesRepository.excluirPorId(id);
    }
}
