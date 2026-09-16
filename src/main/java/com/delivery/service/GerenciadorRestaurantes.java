package com.delivery.service;

import com.delivery.model.Restaurante;
import com.delivery.repository.RestaurantesRepository;

import java.util.List;

public class GerenciadorRestaurantes {
    private RestaurantesRepository restaurantesRepository;

    public GerenciadorRestaurantes(RestaurantesRepository restaurantesRepository){
        this.restaurantesRepository = restaurantesRepository;
    }

    public List<Restaurante> listarRestaurantes(){
        return restaurantesRepository.listarTodos();
    }

    public Restaurante buscarRestaurantePorId(String id){
        return restaurantesRepository.buscarPorId(id);
    }

    public void cadastrarRestaurante(Restaurante restaurante){
        restaurantesRepository.salvar(restaurante);
    }

    public void excluirRestaurante(String id){
        restaurantesRepository.excluirPorId(id);
    }
}
