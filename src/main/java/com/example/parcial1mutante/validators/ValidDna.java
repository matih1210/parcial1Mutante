package com.example.parcial1mutante.validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DnaValidator.class) //@Constraint: Indica que esta anotación es una restricción de validación y la asocia con la clase DnaValidator, que es la que contiene la lógica de validación real. Cuando se usa @ValidDna, se ejecutará la lógica implementada en DnaValidator.
@Target({ElementType.FIELD}) // @Target({ ElementType.FIELD }): Define dónde se puede aplicar la anotación @ValidDna. En este caso, solo puede aplicarse a campos (propiedades de una clase).
@Retention(RetentionPolicy.RUNTIME) // @Retention(RetentionPolicy.RUNTIME): Establece que esta anotación estará disponible en tiempo de ejecución, lo cual es necesario para que el framework de validación pueda acceder y aplicar @ValidDna durante la ejecución del programa.

//Cuando uses @Valid en el controlador, cualquier violación de las reglas de validación causará que el framework lance una excepción MethodArgumentNotValidException, que puedes manejar para devolver respuestas HTTP adecuadas con los mensajes de error.
//Usar la anotación @Valid en el controlador: En lugar de realizar la validación manualmente en el servicio, puedes dejar que el framework de validación de Jakarta Bean Validation maneje eso automáticamente si usas la anotación @Valid en tu controlador. Esto también proporcionará los mensajes de error específicos que ya has implementado en DnaValidator.
public @interface ValidDna {
    String message() default "No se puede validar la dna.";
    Class<?>[] groups() default {}; //  Permite agrupar validaciones. Aunque no se usa comúnmente, es útil en situaciones donde se tiene más de un conjunto de validaciones que deben aplicarse en diferentes contextos.
    Class<? extends Payload>[] payload() default {}; // Permite agregar información adicional a la anotación, que puede ser útil para el manejo avanzado de validaciones (por ejemplo, para dar detalles sobre el tipo de error).
}
