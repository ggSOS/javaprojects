# javaprojects
- projeto de Back End de Auto-Escola com Spring BOOT

# MySQL
- Start MySql Service
- MySQL Workbench
- criar banco de dados
    - Drop Database auto_escola_3espb
    - Create Database auto_escola_3espb
- conectar ao banco de dados

# Dados para POSTMAN
- {
    "nome": "Charles",
    "email": "Charles@gmail.com",
    "cnh": "01234567890",
    "especialidade": "ONIBUS",
    "endereco":{
        "logradouro": "Rua Ibo",
        "numero": "300",
        "complemento": "Apto. 91",
        "bairro": "Vila Regente Feijo",
        "cidade": "São Paulo",
        "uf": "SP",
        "cep": "03346000"
    }
}

- Body da requisição Post (Instrutor: http://localhost:8080/instrutores)

{
    "nome": "{{$randomFullName}}",
    "email": "{{$randomEmail}}",
    "telefone": "{{$randomPhoneNumber}}",
    "cnh": "01234567890",
    "especialidade": "CAMINHOES",
    "endereco": {
        "logradouro": "{{$randomStreetName}}",
        "numero": "{{$randomInt}}",
        "complemento": "Apto. {{$randomInt}}",
        "bairro": "{{$randomCity}}",
        "cidade": "{{$randomCity}}",
        "uf": "SP",
        "cep": "87654321"
    }
}

# Endpoint
- Ex
    - http://localhost:8080/instrutores?size=5&page=0
        - página 1(0) da lista de instrutores paginados de 5 em 5
    - http://localhost:8080/instrutores?sort=nome&size=2&page=1
        - página 2(1) da lista de instrutores paginados de 2 em 2 e ordenados por nome
