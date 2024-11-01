package com.example.parcial1mutante.services;

import com.example.parcial1mutante.Entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base, ID extends Serializable> { // BaseService es una interfaz genérica que define métodos básicos de CRUD (Create, Read, Update, Delete) para manejar cualquier entidad que extienda de Base. Al crear implementaciones específicas de BaseService para diferentes entidades, se puede reutilizar esta funcionalidad sin necesidad de reescribirla, manteniendo la consistencia en la lógica de acceso a datos.
    public List<E> findAll() throws Exception;

    public Page<E> findAll(Pageable pageable) throws Exception;

    public E findById(ID id) throws Exception;

    public E save(E entity) throws Exception;

    public E update(ID id, E entity) throws Exception;

    public boolean delete(ID id) throws Exception;
}


