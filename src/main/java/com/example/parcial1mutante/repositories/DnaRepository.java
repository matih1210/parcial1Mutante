package com.example.parcial1mutante.repositories;

import com.example.parcial1mutante.Entities.Dna;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends BaseRepository<Dna, Long> {
    long countByIsMutant(boolean isMutant);
}
