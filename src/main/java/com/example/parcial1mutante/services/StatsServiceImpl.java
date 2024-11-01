package com.example.parcial1mutante.services;

import com.example.parcial1mutante.Entities.Dna;
import com.example.parcial1mutante.repositories.DnaRepository;
import com.example.parcial1mutante.dto.StatsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service //  define a StatsServiceImpl como un componente de servicio de Spring, lo que permite su inyección automática y gestión por parte del framework.
public class StatsServiceImpl extends BaseServiceImpl<Dna, Long> implements StatsService {

    @Autowired
    private DnaRepository dnaRepository; // es inyectado por Spring, permitiendo el acceso a métodos de consulta en la base de datos para contar secuencias de ADN mutante y humano.

    public StatsServiceImpl(DnaRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public StatsResponse getStats(){
        long countMutantDna = dnaRepository.countByIsMutant(true);
        long countHumanDna = dnaRepository.countByIsMutant(false);
        // countByIsMutant(true) y countByIsMutant(false) obtienen el número de secuencias de ADN mutante y humano, respectivamente.
        double ratio = countHumanDna > 0 ? (double) countMutantDna / countHumanDna : 0.0;
        // ratio se calcula dividiendo countMutantDna entre countHumanDna. Si countHumanDna es 0 (evitando una división por cero), el ratio se establece en 0.0.
        return new StatsResponse((int) countMutantDna, (int) countHumanDna, ratio); // El metodo crea y retorna una instancia de StatsResponse, una clase de DTO (Data Transfer Object) que contiene countMutantDna, countHumanDna, y ratio. Estos valores se utilizan para devolver los resultados como respuesta a las solicitudes.
    }
}
