# Etapa 1: Build da aplicação
FROM gradle:7.6.0-jdk17 AS build

# Define o diretório de trabalho no container
WORKDIR /app

COPY . .

# Baixa as dependências do projeto
RUN ./gradlew build --no-daemon -x test


# Compila a aplicação
RUN ./gradlew clean build -x test

# Etapa 2: Executar a aplicação
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho no container
WORKDIR /app

# Copia o arquivo JAR gerado na etapa anterior
COPY --from=build /app/build/libs/*.jar app.jar

# Exponha a porta em que o aplicativo será executado
EXPOSE 8080

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]