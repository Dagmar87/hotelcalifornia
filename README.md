# Hotel Califórnia

​	Esse projeto Spring Boot foi desenvolvido por José Dagmar Florentino da Silva Sobrinho para o Curso de Treinamento da Flexpag. O projeto consiste na criação de um sistema de cadastramento e de consulta de hotéis e de seus respectivos clientes, utilizando como serviços de APIs, as operações CRUD (Create, Read, Update e Delete) para funcionamento do sistema.

​	As tecnologias usadas nesse projeto foram:

- Linguagem Java (Versão 8)
- Banco de Dados MySQL
- Spring Boot
- Maven 
- JPA
- Hibernate
- RESTful
- Apache Tomcat
- IDE Eclipse
- Insomnia

### Estrutura do Projeto

​	O projeto do Hotel Califórnia possui a seguinte estrutura de pacotes e de classes:

- HotelCalifornia (Projeto)

  - HotelCaliforniaApplication (Classe)

  - Controller (Pacote)
    - HotelController  (Classe)
    - ClienteController (Classe)
    
  - Model (Pacote)
    - Hotel  (Classe)
    - Cliente (Classe)
    
  - Repository (Pacote)
    - HotelRepository  (Classe)
    - ClienteRepository (Classe)
  
  Esse projeto é dividido, como qualquer outro projeto SpringBoot, em 3 pacotes: Controller, Model e Repository. Nesses pacotes contém duas classes para suas respectivas operações: Hotel e Cliente.

### Banco de Dados

​	Para esse projeto, foram criados duas tabelas no banco de dados MySQL que foram as tabelas Hotel, que é tabela primaria do projeto, e Cliente, que é tabela secundaria que é conectada com a tabela Hotel. 

A tabela Hotel contém os seguintes atributos:

- Matricula - INT - PK (Chave Primaria da Tabela) - O numero da matricula do Hotel;
- Nome - STRING  - O nome do Hotel;
- ValorDiario - DOUBLE - O valor diário de uma estadia no Hotel;
- Cidade - STRING - O nome do local onde fica localizado o Hotel;
- Estrelas - DOUBLE - A nota de avaliação dada ao Hotel.

A tabela Cliente contém os seguintes atributos: 

- Nome - STRING - O nome do Cliente;
- Idade - INT -  A idade do Cliente;

- Fone - STRING - O numero de telefone do Cliente; 
- CPF - STRING - PK (Chave Primaria da Tabela) - O numero do CPF do Cliente;
- Email - STRING - O e-mail do Cliente;
- Matricula - INT - FK(Chave Estrangeira da Tabela) - O numero matricula do Hotel e ela é chave estrangeira que conectar as tabelas Hotel e Cliente. 

Esses atributos dessas duas tabelas serão espelhados nos atributos das classes do pacote Model do projeto.

### Operações CRUD do Projeto

​	Nesse projeto foram realizado duas operações CRUD, sendo a primeira as do Hotel, que é considerada a operação primaria do sistema, e as do Cliente,  que é considerada a operação secundaria, já que depende dos valores resultantes da operação primaria (Hotel).    

#### Hotel

​	As operações CRUD do Hotel são divididas em 5 operações que são:

- FindAll/GetAll => Essa operação irá consultar uma lista de todos hotéis cadastrados.  

  URL deste método: http://localhost:8080/hotel

  ![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Curso de Treinamento da Flexpag\Hotel - GetAll.png)

  ​                                                                 O método FindAll/GetAll

- FindByMatricula => Essa operação irá consultar um determinado hotel cadastrado partir da matricula deste.

  URL deste método: http://localhost:8080/hotel/{matricula}

  ![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Curso de Treinamento da Flexpag\Hotel - FindByMatricula.png)

​                                                                 O método FindByMatricula

- Create => Essa operação irá criar um novo cadastro de um hotel.

  URL deste método: http://localhost:8080/hotel

  ![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Curso de Treinamento da Flexpag\Hotel - Create.png)

​                                                                               O método Create

- Update => Essa operação irá atualizar os dados de um hotel cadastrado.

  URL deste método: http://localhost:8080/hotel/{matricula}

  ![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Curso de Treinamento da Flexpag\Hotel - Update.png)

​                                                                                       O método Update

- Delete => Essa operação irá apagar os dados do hotel cadastrado.

  URL deste método: http://localhost:8080/hotel/{matricula}

  ![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Curso de Treinamento da Flexpag\Hotel - Delete.png)

​                                                                                             O método Delete

#### Cliente

As operações CRUD do Cliente são divididas em 5 operações que são:

- FindAll/GetAll => Essa operação irá consultar uma lista de todos clientes cadastrados.  

  URL deste método: http://localhost:8080/cliente

  ![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Curso de Treinamento da Flexpag\Cliente - GetAll.png)

  ​																		O método FindAll/GetAll

- FindByCpf => Essa operação irá consultar um determinado cliente cadastrado partir do CPF deste.

  URL deste método: http://localhost:8080/cliente/{cpf}

  ![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Curso de Treinamento da Flexpag\Cliente - FindByCpf.png)

  ​															O método FindByCpf

- Create => Essa operação irá criar um novo cadastro de um cliente.

  URL deste método:  http://localhost:8080/cliente

  ![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Curso de Treinamento da Flexpag\Cliente - Create.png)

  ​																				O método Create

- Update => Essa operação irá atualizar os dados de um cliente cadastrado.

  URL deste método: http://localhost:8080/cliente/{cpf}

  ![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Curso de Treinamento da Flexpag\Cliente - Update.png)

   																				O método Update

- Delete => Essa operação irá apagar os dados do cliente cadastrado.

  URL deste método: http://localhost:8080/hotel/{matricula}
  
  ![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Curso de Treinamento da Flexpag\Cliente - Delete.png)
  
   																				O método Delete

#### Resultados das Operações no MySQL

​	Após realização das operações CRUD, os dados serão enviados e guardados no banco de dados MySQL nas tabelas Hotel e Cliente, como vemos nas duas imagens abaixo:

###### Hotel

​    ![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Curso de Treinamento da Flexpag\Hotel - Tela MySQL.png) 

​                                           Resultado das Operações CRUD da classe Hotel no MySQL

###### Cliente

![](C:\Users\JOSE DADMAR\Documents\FUCTURA TECNOLOGIAS\Curso de Treinamento da Flexpag\Cliente - Tela MySQL.png)

 											Resultado das Operações CRUD da classe Cliente no MySQL