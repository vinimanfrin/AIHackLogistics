# 🏥 AI Hack Logistcs

## Integrantes:

- 552293 - Vinicius Monteiro Manfrin
- 552302 - Samara De Oliveira Moreira
- 551261 - Giovanni Sguizzardi Conde
- 98057 - Nicolas Eiti Inohue
- 99841 - Marcel Prado Soddano

## Vídeo explicativo no YouTube
https://youtu.be/CYTRZDvArG4

## Descrição

Este é um sistema de gerenciamento médico desenvolvido com *Java 17, utilizando o framework **Spring Boot* e *Thymeleaf* para a camada de visualização. O sistema tem como objetivo gerenciar *médicos*,*pacientes* e *consultas*. 

A aplicação foi implementada para fins acadêmicos, e utiliza um banco de dados *H2* em memória, o que facilita a configuração e o uso sem necessidade de instalação de banco de dados externo.

## Funcionalidades

- *CRUD de Médicos*: Cadastro, edição, listagem e exclusão de médicos.
- *CRUD de Pacientes*: Cadastro, edição, listagem e exclusão de pacientes.
- Visualização de Consultas

## Tecnologias Utilizadas
- *Java 17*
- *Spring Boot*
- *Thymeleaf* (para renderização de páginas HTML)
- *Banco de dados H2* (em memória)
- Javascript

## Como Executar

### Pré-requisitos

- Java 17 instalado
- Maven para gerenciar as dependências
- Docker

### Passos para execução

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git

2. Acesse o diretório do projeto:
    ```bash
    cd seu-repositorio

3. Baixe as dependências e compile o projeto:
    ```bash
    mvn clean install

4. Faça o clone do worker do RabbitMQ e o configure de acordo com as instruções em:
    ```bash
    https://github.com/vinimanfrin/AIHackLogisticsWorker

5. Inicie a aplicação:
    ```bash
    mvn spring-boot:run

6. Acesse a aplicação e navegue entre as páginas no seu navegador em:
    ```bash
    http://localhost:8080

## Banco de Dados

-O projeto utiliza o banco de dados H2, que é um banco em memória. Não há necessidade de configuração externa para o banco, pois os dados são criados automaticamente ao iniciar a aplicação.

1. Acesse o console do banco de dados H2 em:
      ```bash
      http://localhost:8080/h2-console
