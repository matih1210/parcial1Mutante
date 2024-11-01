package com.example.parcial1mutante.services;

import com.example.parcial1mutante.Entities.Base;
import com.example.parcial1mutante.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> { // BaseServiceImpl actúa como una implementación genérica de BaseService, proporcionando la lógica de CRUD común para cualquier entidad que extienda de Base.
    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baserepository) {
        this.baseRepository = baserepository;
    }
    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = baseRepository.findAll(); // va a obtener da la BD todas las instancias de la entidad.
            return entities; // Retorna una lista de esas entidades
        } catch (Exception e){
            throw new Exception(e.getMessage()); // lanza el msj de la exepcion
        }
    }

    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception{
        try {
            Page<E> entities = baseRepository.findAll(pageable);
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id); // se usa optional(del tipo de la entidad)porque no se sabe si se va a encontrar o no la entidad
            return entityOptional.get(); // Devuelve la entidad si la encuentra y sino tira la excepcion
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = baseRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOpcional = baseRepository.findById(id); // se usa el optional pq hay que buscar si existe el objeto que se quiere actualizar
            E entityUpdate = entityOpcional.get(); // si encuentra la entidad la asigna a entityUpdate y si no lanza ecepcion
            entityUpdate = baseRepository.save(entity); // guarda la entidad actualizada en la entidad vieja
            return entityUpdate;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try { // se usa if para ver si exite una entidad con ese ID, si existe lo elimina y retorna true, si no existe lanza excepcion
            if (baseRepository.existsById(id)) {
                baseRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
