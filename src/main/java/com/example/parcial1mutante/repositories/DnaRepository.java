package com.example.parcial1mutante.repositories;

import com.example.parcial1mutante.Entities.Dna;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository // Indica que DnaRepository es un repositorio de Spring. Esto permite a Spring gestionar esta interfaz y habilitar la inyección de dependencias en otras partes de la aplicación donde se necesite interactuar con los datos de ADN.
public interface DnaRepository extends BaseRepository<Dna, Long> { // Define una interfaz específica para la entidad Dna. Hereda de BaseRepository, proporcionando todos los métodos CRUD estándar definidos en JpaRepository. Esto asegura que DnaRepository pueda realizar operaciones básicas en la base de datos sobre objetos de tipo Dna
    long countByIsMutant(boolean isMutant);//La convención de nombres de Spring Data JPA (countBy) permite que el metodo se implemente automáticamente, evitando escribir consultas SQL. En este caso, countByIsMutant contará todos los registros de Dna donde el campo isMutant sea true o false, según el valor del parámetro isMutant.
    // Metodo que busca una entidad Dna por su campo dna.
    Optional<Dna> findByDna(String dna);
}
