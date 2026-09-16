package com.delivery.repository;

import com.delivery.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClientesRepository {
    private List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente cliente){
        clientes.add(cliente);
    }

    public Cliente buscarPorId(String id){
        for (Cliente cliente : clientes){
            if (cliente.getId().equals(id)){
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> listarTodos(){
        return List.copyOf(clientes);
    }

    public void excluirPorId(String id){
        clientes.remove(buscarPorId(id));
    }
}
