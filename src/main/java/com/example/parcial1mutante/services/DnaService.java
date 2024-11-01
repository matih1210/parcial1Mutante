package com.example.parcial1mutante.services;

import com.example.parcial1mutante.Entities.Dna;

public interface DnaService extends BaseService<Dna, Long> { // DnaService es una interfaz específica para el manejo de lógica de negocio de detección de ADN mutante. Al heredar de BaseService, se asegura de tener métodos CRUD generales sin necesidad de duplicar código. Además, añade el metodo isMutant, que es único para la lógica de detección de ADN mutante en la aplicación.
    boolean isMutant(String[] dna) throws Exception;

}