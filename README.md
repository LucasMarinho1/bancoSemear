# Api de Propaganda
Trata-se de um Api para propaganda de empresas que estao proximas ao usuario do sistema.

OBS: para rodar a API sera necessario gerar um token, atraves do [http://localhost:8080/authenticate](http://localhost:8080/authenticate),
e colocar no Postman, o arquivo do postman ja possui esse token, porem sera necessario atualiza-lo.

## Executar/Compilar

**Utilizados**
- IDE: eclipse (2020-06 (4.16.0) + Spring tools 4
- Sistema Operacional Windows 10
- Git (2.27.0.windows.1)
- Spring Boot (2.3.1.RELEASE)
- Java (1.8)
- Datatables (1.10.19)
- Banco de dados H2

**Compilar**

clone o projeto para seu local e execute o comando.

```
mvn package exec:java
```
## Executar Aplicação 

O arquivo de importação do postman se encontra na raiz para facilitar a utilização.

```

```
## Documentação no swagger

para acessar --> http://localhost:8080/swagger-ui.html

## links úteis
 
 Acessar Banco de dado H2.


- **Driver Class:** org.h2.Driver
- **JDBC URL:** jdbc:h2:mem:testdb
- **User Name:**
- **Password:**

[http://localhost:8080/h2-console](http://localhost:8080/h2-console)


Pagina inicial da aplicação.

[http://localhost:8080/api](http://localhost:8080/api)

Acessar Swagger - documentacao

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
