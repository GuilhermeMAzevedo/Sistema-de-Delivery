package com.delivery.repository;

import com.delivery.datastructure.ListaEncadeadaDupla;
import com.delivery.model.Cliente;

public class ClienteRepository {
    private ListaEncadeadaDupla<Cliente> clientes = new ListaEncadeadaDupla<>();

    public void salvar(Cliente cliente){
        clientes.inserirFinal(cliente);
    }

    public Cliente buscarPorId(String id){
        for (Cliente cliente : clientes){
            if (cliente.getId().equals(id)){
                return cliente;
            }
        }
        return null;
    }

    public ListaEncadeadaDupla<Cliente> getClientes(){
        return clientes;
    }

    public void excluirPorId(String id){
        clientes.remover(clientes.buscar(buscarPorId(id)));
    }
}
