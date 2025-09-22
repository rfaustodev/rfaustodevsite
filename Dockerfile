# Usar imagem oficial do Java 17
FROM eclipse-temurin:17-jdk-alpine

# Definir diretório de trabalho
WORKDIR /app

# Copiar projeto
COPY . .

# Build do projeto com Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Expor a porta
EXPOSE 8080

# Comando para rodar o JAR gerado
CMD ["java", "-jar", "target/*.jar"]

