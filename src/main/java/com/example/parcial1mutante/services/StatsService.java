package com.example.parcial1mutante.services;

import com.example.parcial1mutante.Entities.Dna;
import com.example.parcial1mutante.dto.StatsResponse;

public interface StatsService extends BaseService<Dna, Long>{ // StatsService es una interfaz específica para el manejo de lógica de negocio conseguir las Stats de cantidad de humanos y mutantes. Al heredar de BaseService, se asegura de tener métodos CRUD generales sin necesidad de duplicar código. Además, añade el metodo StatsResponse, que es único para la lógica de conseguir las stats.
    StatsResponse getStats();
}
