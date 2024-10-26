package com.example.parcial1mutante.controllers;

import com.example.parcial1mutante.dto.DnaRequest;
import com.example.parcial1mutante.dto.DnaResponse;
import com.example.parcial1mutante.services.DnaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/humanos/dnas")
public class DnaController {

    @Autowired
    private DnaService service;

    @PostMapping("/mutant")
    public ResponseEntity<DnaResponse> isMutant(@Valid @RequestBody DnaRequest dnaRequest) {
        if (dnaRequest == null || dnaRequest.getDna() == null) {
            DnaResponse response = new DnaResponse("El request de ADN es nulo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        System.out.println("Received DNA: " + Arrays.toString(dnaRequest.getDna()));

        try {
            boolean isMutant = service.isMutant(dnaRequest.getDna());
            DnaResponse response = new DnaResponse(isMutant);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e){
            // Captura de excepciones de DnaValidator
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DnaResponse(e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el stack trace para depuración
            DnaResponse response = new DnaResponse("Ha ocurrido un error.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

