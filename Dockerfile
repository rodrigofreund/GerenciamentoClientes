FROM openjdk:8
MAINTAINER Rodrigo Freund de Moraes
COPY ./target/*.jar /usr/src/GerenciamentoClientes/
WORKDIR /usr/src/GerenciamentoClientes/
ENTRYPOINT java -Dspring.profiles.active=tst -jar CadastroClienteAPI-0.0.1.jar
EXPOSE 8080
