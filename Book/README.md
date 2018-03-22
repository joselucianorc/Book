1 Importe o projeto no eclipse como um projeto maven

2 execute mvn clean install

3 Crie a base de dados e a tabela que será usada na aplicação conforme ddls abaixo

4 Crie a base de dados e a tabela utilizada
CREATE DATABASE `livraria` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `livro` (
  `sku` bigint(10) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`sku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

5 Configure o acesso a base de dados
No arquivo database.properties preencha o usuário e senha do banco de dados 

6
Utilizei o servidor na porta 8080 caso não estejam usando nesta porta a url deverá ser retificada para refletir a url usada.

7
Chamadas de testes feitas

Inclusão

Executado:
http://localhost:8080/book?sku=9731880

Resultado obtido:
201 Created
{
    "sku": 9731880,
    "name": "Origem",
    "brand": "Arqueiro",
    "price": 49.9
}

Exclusão

Executado:
http://localhost:8080/book/9731880

Resultado obtido:
204 No Content


Consulta

Executado:
*Pré requisito: executar a inclusão primeiro
http://localhost:8080/book/9731880

Resultado Obtido:
200 OK
{
    "sku": 9731880,
    "name": "Origem",
    "brand": "Arqueiro",
    "price": 49.9
}


Listar

Executado:
http://localhost:8080/book?price=50.00&limit=5

Resultado obtido:

[
    {
        "sku": 9731880,
        "name": "Origem",
        "brand": "Arqueiro",
        "price": 49.9
    },
    {
        "sku": 9731881,
        "name": "Origem",
        "brand": "Arqueiro",
        "price": 49.9
    },
    {
        "sku": 9731882,
        "name": null,
        "brand": null,
        "price": 0
    },
    {
        "sku": 9731883,
        "name": "Origem",
        "brand": "Arqueiro",
        "price": 49.9
    }
]





