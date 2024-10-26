package com.example.parcial1mutante.controllers;

import com.example.parcial1mutante.Entities.Base;
import com.example.parcial1mutante.services.BaseServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseControllerImpl <E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> { // Ademas de la Entidad, indicamos que recibe un servicio(en vez del ID)que extiende de BaseServicesImpl con la entidad y el ID(con su tipo)

    //@Autowired
    protected S service;

    @GetMapping("")//Aca sepone el tipo de request(Get,Post,Put,Delete), dentro del @GetMapping se puede poner la uri de este metodo
    public ResponseEntity<?> getAll(){ // Corresponde con el metodo findAll de nuestro servicio
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());  // Estos metodos devuelven un ResponseEntity, este Response entity nos devuelve los status(Si salio bien o mal, que se hace con un codigo de HttpStatus(Ok,NotFound,etc)) de las respuestas en formato JSON para nuestra aplicacion web. El HttpStatus en este caso si sale bien es OK
            // Tmb va a tener un body en el que vamos a enviar los datos a la aplicqacion web. En el cuerpo se llama al servicio findAll (service.findAll()), si se encuantran entidades devuelve una lista con todas las entidades
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Por favor intente más tarde.\"}"); //En este caso el HttpStatus si sale mal es NOT_FOUND, y en el body se genera un msj en formato JSON, que es el formato en que se envia las respuestas a al aplicacion web(cliente).
        }                                                        //Atributo de tipo error
    }

    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){// Corresponde con el metodo findById de nuestro servicio, el id se pone con @PathVariable porque es una variable que esta dentro del path(de la uri)
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Por favor intente más tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){ // Corresponde con el metodo save de nuestro servicio. La entidad se tiene que declarar como que esta dentro del body del request, esto es que para recibir una entidad debo declararla en el body de la request Post¿Que?
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por favor intente más tarde.\"}");//En este caso el HttpStatus si sale mal es BAD_REQUEST
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){ // Corresponde con el metodo update de nuestro servicio
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){ // Corresponde con el metodo delete de nuestro servicio
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id)); // El HttpStatus en este caso si sale bien es NO_CONTENT
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Por favor intente más tarde.\"}");
        }
    }
}