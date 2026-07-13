# Imagen base con Maven y JDK 8
FROM maven:3.8.7-eclipse-temurin-8

# Directorio de  trabajo dentro del contenedor
WORKDIR /app

# Copiamos el pom.xml primero para cachear dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el resto del código
COPY . .

# Exponemos el puerto de Spring Boot
EXPOSE 8080

# Comando por defecto (puedes sobrescribirlo al correr el contenedor)
CMD ["bash"]
