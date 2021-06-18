FROM mysql
LABEL Rodrigo Freund de Moraes
ENV MYSQL_ROOT_PASSWORD=lp0Uti0k
ENV MYSQL_DATABASE=CadastroClientesDb
EXPOSE 3306
ADD schema.sql /docker-entrypoint-initdb.d
