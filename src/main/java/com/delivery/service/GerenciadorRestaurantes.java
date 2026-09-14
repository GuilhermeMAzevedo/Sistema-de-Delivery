package com.delivery.service;

import com.delivery.datastructure.ListaEncadeadaDupla;
import com.delivery.model.Restaurante;
import com.delivery.repository.RestauranteRepository;

public class GerenciadorRestaurantes {
    private RestauranteRepository restauranteRepository;

    public GerenciadorRestaurantes(RestauranteRepository restauranteRepository){
        this.restauranteRepository = restauranteRepository;
    }

    public RestauranteRepository getRestauranteRepository(){
         return restauranteRepository;
    }

    public Restaurante buscarRestaurantePorId(String id){
        return restauranteRepository.buscarPorId(id);
    }

    public void cadastrarRestaurante(Restaurante restaurante){
        restauranteRepository.salvar(restaurante);
    }

    public void excluirRestaurante(String id){
        restauranteRepository.excluirPorId(id);
    }
}
