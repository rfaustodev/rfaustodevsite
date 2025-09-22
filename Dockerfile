# Usar imagem oficial do Java 17 (leve)
FROM eclipse-temurin:17-jdk-alpine

# Definir diretório de trabalho
WORKDIR /app

# Copiar todo o projeto para dentro do container
COPY . .

# Compilar o projeto e gerar o JAR
RUN ./mvnw clean package -DskipTests && \
    cp target/*.jar app.jar

# Expor a porta 8080 (Spring Boot padrão)
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]

