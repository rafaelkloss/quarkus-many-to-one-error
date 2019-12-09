# QUARKUS hibernate proxy BytecodeProvider error:


## Requirements

- config the application resources (database postgres)
- generate native image -> docker build --build-arg version=homolog -t bug-proxy .
- docker run image -> docker run -it --rm --name bug-proxy -p 8080:8080 bug-proxy
- make a post to http://localhost:8080/v1/feedback/create-project (create a project with a lot of relations)
- make a get to http://localhost:8080/v1/feedback/error-proxy to get project above, the error throw 