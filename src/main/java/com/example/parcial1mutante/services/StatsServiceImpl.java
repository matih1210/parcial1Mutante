package com.example.parcial1mutante.services;

import com.example.parcial1mutante.Entities.Dna;
import com.example.parcial1mutante.repositories.DnaRepository;
import com.example.parcial1mutante.dto.StatsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatsServiceImpl extends BaseServiceImpl<Dna, Long> implements StatsService {

    @Autowired
    private DnaRepository dnaRepository;

    public StatsServiceImpl(DnaRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public StatsResponse getStats(){
        long countMutantDna = dnaRepository.countByIsMutant(true);
        long countHumanDna = dnaRepository.countByIsMutant(false);

        double ratio = countHumanDna > 0 ? (double) countMutantDna / countHumanDna : 0.0;

        return new StatsResponse((int) countMutantDna, (int) countHumanDna, ratio);
    }
}
