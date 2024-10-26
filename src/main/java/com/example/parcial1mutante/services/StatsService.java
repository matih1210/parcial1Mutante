package com.example.parcial1mutante.services;

import com.example.parcial1mutante.Entities.Dna;
import com.example.parcial1mutante.dto.StatsResponse;

public interface StatsService extends BaseService<Dna, Long>{
    StatsResponse getStats();
}
