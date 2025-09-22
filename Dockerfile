# Usar imagem oficial do Java 17
FROM eclipse-temurin:23-jdk

# Definir diretório de trabalho
WORKDIR /app

# Copiar projeto
COPY . .

# Build do projeto com Maven Wrapper
RUN ./mvnw clean package -DskipTests
	cp target/*.jar app.jar

# Expor a porta
EXPOSE 8080

# Comando para rodar o JAR gerado
CMD ["java", "-jar", "app.jar"]

