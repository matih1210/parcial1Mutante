package com.example.parcial1mutante.repositories;

import com.example.parcial1mutante.Entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean // Esta anotación indica que BaseRepository es una clase base abstracta y no debe ser instanciada directamente. Y otras interfaces la extiendan y creen repositorios específicos para cada entidad.
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> { // Define un repositorio genérico para entidades que extienden Base, y que tengan un campo id.
                                                                                                         // BaseRepository extiende JpaRepository, una interfaz de Spring Data JPA que provee métodos estándar de operaciones de base de datos (como findAll(), save(), deleteById(), etc.).
}

