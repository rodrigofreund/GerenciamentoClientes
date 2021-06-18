# GerenciamentoClientes
Projeto Desenvolvido por Rodrigo Freund de Moraes para Builders


Detalhes do projeto pode ser encontrado no arquivo Projeto Cadastro Cliente REST API.docx

Para executar o projeto no Eclipse deve-se:

1 - Levantar o container do banco de dados usando o db.dockerfile contido no projeto.
2 - Criar o banco de dados conforme o arquivo schema.sql na raiz do projeto.
3 - Subir a aplicação no eclipse passando como VM arguments -Dspring.profiles.active=dev

Para utilizar o docker compose para subir a aplicação é necessário subistituir a linha "CADASTROCLIENTE_PROFILE=prd"
 po "CADASTROCLIENTE_PROFILE=dev" antes de rodas o docker-compose up.


