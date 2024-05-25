# Clinica Odontológica API REST - JAVA e Spring Boot
<br>

<div align='center'>
  <img src="https://github.com/jaysijj/apirest-clinica-odontologica/assets/93339762/cce15fec-e799-48ff-ac5c-34aaa960d6b5" alt="Imagem Centralizada" alt="Imagem Centralizada"" >
</div>
<br> 

## Sobre o projeto
O projeto consiste em um backend para uma aplicação de gerenciamento de clínica odontológica, utilizando Java e Spring Boot. Ele aborda três entidades principais: Usuario, Dentist e Appointment, cada uma mapeada para tabelas no banco de dados. Com camadas Model, DTO, Repository, Service e Controller, oferece operações CRUD e lógica de negócios bem estruturadas. Além disso, inclui documentação das rotas da API usando Swagger, seguindo as melhores práticas de desenvolvimento de APIs RESTful.

<br>

<div align='center'>
  <img src="https://github.com/jaysijj/apirest-clinica-odontologica/assets/93339762/7aded169-2a3e-45e3-ab24-879bd1ee805f" alt="Imagem Centralizada" alt="Imagem Centralizada"" >
</div>

<br>

- A entidade Usuario representa os usuários do sistema, sejam eles pacientes ou dentistas. Defini atributos como nome de usuário, CPF, senha, e-mail e papel (indicando se é paciente ou dentista).
- Já a entidade Dentist representa os profissionais que trabalham na clínica. Nela, incluí campos como nome, especialidade, telefone, endereço e horário de atendimento.
- Por fim, a entidade Appointment é responsável por representar as consultas marcadas na clínica. Nela, adicionei informações como o ID do paciente, o ID do dentista, a data da consulta e uma breve descrição.

## Tecnologias
- JAVA: linguagem de programação multiplataforma, orientada a objetos e amplamente utilizada para desenvolvimento de software;
- Spring Boot: Framework que simplifica o desenvolvimento de aplicativos em JAVA;
- Swagger: para documentação da API;
- Flyway: para aplicar as migrações necessárias e manter o controle de versionamento.
