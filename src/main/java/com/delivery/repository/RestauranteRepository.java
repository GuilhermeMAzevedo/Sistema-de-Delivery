package com.delivery.repository;

import com.delivery.datastructure.ListaEncadeadaDupla;
import com.delivery.model.Restaurante;

public class RestauranteRepository {
    private ListaEncadeadaDupla<Restaurante> restaurantes = new ListaEncadeadaDupla<>();

    public void salvar(Restaurante restaurante){
        restaurantes.inserirFinal(restaurante);
    }

    public Restaurante buscarPorId(String id){
        for (Restaurante restaurante : restaurantes){
            if (restaurante.getId().equals(id)){
                return restaurante;
            }
        }
        return null;
    }

    public ListaEncadeadaDupla<Restaurante> getRestaurantes(){
        return restaurantes;
    }

    public void excluirPorId(String id){
        restaurantes.remover(restaurantes.buscar(buscarPorId(id)));
    }
}
