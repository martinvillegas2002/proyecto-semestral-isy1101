# ETAPA 1: Construcción (Compilar el código Java)
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
# Copiamos dependencias y código fuente
COPY pom.xml .
COPY src ./src
# Compilamos saltando los tests
RUN mvn clean package -DskipTests

# ETAPA 2: Ejecución (Crear la imagen final ligera)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Traemos el .jar compilado
COPY --from=build /app/target/*.jar app.jar
# Exponemos el puerto 8081 (El que usa este backend específico)
EXPOSE 8081
# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]