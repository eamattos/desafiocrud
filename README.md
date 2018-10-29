Desafio Ebix Outubro 2018
Autor: Edson Mattos (edsonmattos at gmail.com)

* INSTRUÇÔES DE BUILD

no diretório onde se encontra o arquivo pom.xml

$ mvn clean install


* EXECUÇÃO

Para executar
$ mvn jetty:run

* ACESSO
Acesso ao WSDL do server-side CRUD
http://localhost:8080/desafiows?wsdl

Acesso ao REST de Consulta CEP dos Correios
http://localhost:8080/desafio/correios/cep/XXXXX-XXX
ou
http://localhost:8080/desafio/correios/cep/XXXXXXXX

* INFO

Java 1.8
Maven 3.5.2
Spring 5.0.1
Apache CXF 3.2.6
Jetty Server 9.4.2


* REQUISITOS

Construir uma aplicação Java utilizando: 

- Spring Core para injeção de dependência
- Spring Jdbc com JDBCTemplate para acesso a dados


Atividades: 

1) Criar o server-side de um CRUD utilizando RowMapper para a obtenção dos dados

2) Expor o CRUD como webservice SOAP

3) Consumir o serviço consulta CEP do WSDL 
https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl utilizando CXF para geração do client

4) Expor o serviço do passo 3 como REST ( utilizando JAX-RS)
