# Archivo para que se deployee en la nube. Este archivo busca un set reducido de Linux, que tiene comandos básicos para que se ejecute una aplicacion que se llama Apline
FROM alpine:latest as build

RUN apk update
RUN apk add openjdk17

COPY . .
RUN chmod +x ./gradlew
# Este tiene una relacion directa con el bootJar en el archivo build.gradle  va a correr el programa y va a embeber el tomcat y nuestra aplicacion en un archivo Jar y lo va a generar en una carpeta que se llama live, ese jar que va a crearse se va a llavar demo-app como se especifica más abajo. Lo que hago aca en un script para que en la nube se haga automaticamento todos los pasos y se genere en render el demo-app.jar
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-alpine
EXPOSE 9000
COPY --from=build ./build/libs/Parcial1Mutante-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

#El docker guarda un linux chiquito, una maquina virtual y un ejecutable del programa en una capsula para que pueda ejecutarse el programa en cualquier lado.