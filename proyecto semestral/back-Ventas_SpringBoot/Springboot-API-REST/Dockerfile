# ETAPA 1: Construcción (Compilar el código Java)
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
# Copiamos el archivo de dependencias y el código fuente
COPY pom.xml .
COPY src ./src
# Compilamos el proyecto saltando las pruebas para que sea más rápido
RUN mvn clean package -DskipTests

# ETAPA 2: Ejecución (Crear la imagen final ligera)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copiamos el archivo .jar ya compilado de la etapa anterior
COPY --from=build /app/target/*.jar app.jar
# Exponemos el puerto por defecto de Spring Boot
EXPOSE 8080
# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]