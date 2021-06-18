FROM openjdk:8
LABEL Rodrigo Freund de Moraes
COPY ./target/*.jar /usr/src/GerenciamentoClientes/
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.9.0/wait /wait
WORKDIR /usr/src/GerenciamentoClientes/
CMD /wait && java -Dspring.profiles.active=${CADASTROCLIENTE_PROFILE} -jar CadastroClienteAPI-0.0.1.jar
EXPOSE 9000
RUN chmod +x /wait
