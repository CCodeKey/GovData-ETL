# GovData ETL

## Sobre
Aplicação desenvolvida para a disciplina de Banco de Dados II com foco em:

- ETL (Extract, Transform, Load)
- Tratamento de dados não conformes
- Normalização de dados
- Modelagem relacional

A aplicação lê um arquivo CSV de dados públicos disponíveis na plataforma de dados abertos do [governo federal](https://dados.gov.br), e persiste as informações em um banco relacional utilizando Spring Boot + JPA + MySQL.

---

## Como Funciona

1. Lê o arquivo CSV ao iniciar
2. Trata dados (nulos, inconsistências)
3. Normaliza as informações
4. Salva no banco automaticamente

---

## Autores 
<table> <tr> <td align="center"> <a href="https://github.com/CCodekey"> <img src="https://avatars.githubusercontent.com/u/105808889?v=4" width="100px;" alt="Gabriel T."/><br> <sub> <b>Gabriel Tertuliano</b> </sub> </a> </td> <td align="center"> <a href="https://github.com/kaleu-victor"> <img src="https://avatars.githubusercontent.com/u/169067294?v=4" width="100px;" alt="Kaléu V."/><br> <sub> <b>Kaléu Victor</b> </sub> </a> </td> </tr> </table>

---

## Tecnologias

- Java
- Spring Data JPA
- Hibernate
- MySQL
- OpenCSV

---

## 🚀 Execução
### 1. Clonar o projeto
```bash
git clone https://github.com/CCodeKey/GovData-ETL
```

### 2. Subir o BD com Docker
```bash
docker run -d --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=govData -p 3306:3306 mysql
```
### 3. Executar a aplicação
```bash
mvn spring-boot:run
```
