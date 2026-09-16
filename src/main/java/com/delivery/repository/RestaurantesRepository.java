package com.delivery.repository;

import com.delivery.model.Restaurante;
import java.util.ArrayList;
import java.util.List;

public class RestaurantesRepository {
    private List<Restaurante> restaurantes = new ArrayList<>();

    public void salvar(Restaurante restaurante){
        restaurantes.add(restaurante);
    }

    public Restaurante buscarPorId(String id){
        for (Restaurante restaurante : restaurantes){
            if (restaurante.getId().equals(id)){
                return restaurante;
            }
        }
        return null;
    }

    public List<Restaurante> listarTodos(){
        return List.copyOf(restaurantes);
    }

    public void excluirPorId(String id){
        restaurantes.remove(buscarPorId(id));
    }
}
