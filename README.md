# QUARKUS error persist many-to-one:


## Requirements

- config the application resources (database postgres)
- start quarkus
- make a post to http://localhost:8080/v1/feedback/solicitar/interno with the body
{
    "descricao": "test - text",
    "usuarioSolicitacao": {
    	"id":3
    }
}
