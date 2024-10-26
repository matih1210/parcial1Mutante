package com.example.parcial1mutante.services;

import com.example.parcial1mutante.Entities.Dna;

public interface DnaService extends BaseService<Dna, Long> {
    boolean isMutant(String[] dna) throws Exception;

}