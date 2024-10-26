package com.example.parcial1mutante.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class DnaValidator implements ConstraintValidator<ValidDna, String[]> {

    @Override
    public void initialize(ValidDna constraintAnnotation){
        // Inicialización si es necesaria
    }

    @Override
    public boolean isValid(String[] dna, ConstraintValidatorContext context) {
        System.out.println("Validating DNA: " + Arrays.toString(dna));

        // Si el array es nulo, establece un mensaje de error y retorna falso
        if (dna == null) {
            context.buildConstraintViolationWithTemplate("El array de ADN no puede ser nulo")
                    .addConstraintViolation(); // Agrega la violación al contexto
            return false;
        }

        if (dna.length == 0) {
            context.buildConstraintViolationWithTemplate("El array de ADN no puede estar vacío")
                    .addConstraintViolation(); // Agrega la violación al contexto
            return false;
        }

        int n = dna.length;
        // Validar que el array sea cuadrado y no contenga filas nulas
        for (String row : dna) {
            if (row == null || row.length() != n) {
                context.buildConstraintViolationWithTemplate("El array de ADN debe ser cuadrado (NxN) y no debe contener filas nulas")
                        .addConstraintViolation(); // Agrega la violación al contexto
                return false;
            }
        }

        // Validar que cada carácter en las filas sea 'A', 'C', 'G' o 'T'
        for (String row : dna) {
            for (char c : row.toCharArray()) {
                if (c == '\0') {
                    context.buildConstraintViolationWithTemplate("El array no puede contener caracteres nulos")
                            .addConstraintViolation(); // Agrega la violación al contexto
                    return false;
                }
                System.out.println("Validating character: " + c);
                if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
                    context.buildConstraintViolationWithTemplate("El array solo puede contener letras A, C, G y T")
                            .addConstraintViolation(); // Agrega la violación al contexto
                    return false;
                }
            }
        }
        // Si todas las validaciones se cumplen, retorna true
        return true;
    }

}
