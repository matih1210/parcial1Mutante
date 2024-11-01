# Proyecto Detección de ADN Mutante

Este proyecto fue desarrollado como parte del parcial para detectar mutantes basándose en secuencias de ADN, cumpliendo los requerimientos planteados por Magneto para identificar a los mutantes en la población.

## Descripción del Proyecto

Este programa permite determinar si una persona es mutante a partir de su secuencia de ADN representada en una matriz NxN. Cada posición contiene una de las bases nitrogenadas: **A**, **T**, **C**, **G**. La persona se considera mutante si en su secuencia existen más de una secuencia de cuatro letras idénticas de forma horizontal, vertical u oblicua.

### Ejemplos

- **Secuencia mutante verdadera**

  String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
  isMutant(dna); // Devuelve true

- **Secuencia mutante falsa**
  
  String[] dna = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
  isMutant(dna); // devuelve false

## Niveles de Implementación

### Nivel 1: Algoritmo de Detección de Mutantes
La función isMutant(String[] dna) determina si una secuencia es mutante utilizando búsquedas eficientes en matrices para localizar secuencias de cuatro letras consecutivas en las tres direcciones: horizontal, vertical y oblicua.

### Nivel 2: Creación de la API REST

Endpoint /mutant/: API que recibe secuencias de ADN en formato JSON. Si la secuencia es mutante, devuelve un estado 200 OK; de lo contrario, devuelve 403 Forbidden.

**Ejemplo de solicitud:**

POST /mutant/
{
  "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}

La API está desplegada en un servicio de cloud computing para facilitar su acceso.

### Nivel 3: Base de Datos y Estadísticas

**Base de Datos:** Se integra una base de datos que guarda cada secuencia de ADN analizada, evitando duplicados.
**Endpoint /stats/:** Devuelve estadísticas de las verificaciones realizadas, indicando el número de mutantes, humanos y la proporción (ratio) entre ambos.

**Ejemplo de respuesta:**

{
  "count_mutant_dna": 40,
  "count_human_dna": 100,
  "ratio": 0.4
}

## Escalabilidad y Tolerancia a Alta Carga
El diseño de la API contempla picos de tráfico de hasta 1 millón de peticiones por segundo. Para esto, se implementaron mecanismos de escalabilidad y optimización de consultas.

## Requisitos
Java 17
Spring Boot
Base de datos (opcional para pruebas locales)
Docker (para despliegues)

## Ejecucion
1. Clonar el Repositorio:
git clone <https://github.com/matih1210/parcial1Mutante>
cd proyecto-mutante (nombre del proyecto)

2. Construir y Ejecutar la Aplicacion:
./gradlew bootRun

3. Acceso a la API de forma local
Verificación de ADN: En postan uso un POST con la url: http://localhost:8080/api/humanos/dnas/mutant
Estadisticas: En postman uso un GET con la url: http://localhost:8080/api/humanos/stats

4. Acceso a la API en la nube
Verificación de ADN: En postan uso un POST con la url: https://parcial1mutante.onrender.com/api/humanos/dnas/mutant

Estadisticas: En postman uso un GET con la url: https://parcial1mutante.onrender.com/api/humanos/stats

Al GET tambien se puede copiar en un browser y te trae las estadisticas de la aplicacion en la nube.

## Pruebas y Cobertura
Las pruebas automáticas alcanzan una cobertura del código mayor al 80%, verificando tanto la lógica de detección de mutantes como la correcta respuesta de los endpoints.

## Documentación Adicional
Para más detalles sobre el funcionamiento interno y la arquitectura del sistema, consulta el archivo PDF incluido en el repositorio. Donde se muestran pruebas de stress y performance con jmeter. Se muestra un par de diagramas de secuencia para el metodo POST y GET. Y tambien una arquitectura del sistema.
