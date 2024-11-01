package com.example.parcial1mutante.controllers;

import com.example.parcial1mutante.Entities.Base;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

// Este código define una interfaz BaseController, que establece un conjunto de métodos para manejar operaciones básicas de un controlador
public interface BaseController <E extends Base, ID extends Serializable> { // Esta interfaz es genérica y está parametrizada con dos tipos: E, que extiende Base, y ID, que es un tipo que implementa Serializable. Esto permite que la interfaz se use con diferentes entidades y tipos de ID a lo largo de la aplicación.
    public ResponseEntity<?> getAll(); //Response Entity es una clase parametrizada, el ? indica que recibe cualquier objeto q extienda de object
    public ResponseEntity<?> getAll(Pageable pageable);
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?> delete(@PathVariable ID id);
}