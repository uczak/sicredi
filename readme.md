<h1 align="center">Projeto</h1>
<p align="center">Este projeto sobe um banco H2 em memória para o armazenamento dos dados. Foi desenvolvido com Java - Spring Boot.</p>


<br/><h2 align="left">Definições de desenvlvimento solicitadas</h2>
<p>O arquivo com as definições solicitadas esta dentro do projeto no diretório a baixo.</p>

````txt
🗂️ src/
├── 📂 main/
│   └── 📂 resources/
│       └── 📂 static/
│            └── 📝 definicoes.txt
````

<br/><h2 align="left">Tecnologias</h2>
<ul>
  <li>Java 17</li>
  <li>Spring boot 2.7.11</li>
  <li>Gradlew 7.6</li>
</ul>

<br/><h2 align="left">Estrutura de dados</h2>

<p>Estrutura de dados criada para relacionar produtos, pessoas e compras. A tabela compra_produto foi criada para ser possível uma compra ter N produtos associados respeitando as regras solicitadas na definição.</p>

<p>Diagrama ER:</p>

![Diagrama ER](https://github.com/uczak/sicredi/blob/main/src/main/resources/static/DiagramaER.PNG)

Ao subir a aplicação o banco H2 sera criado com alguns registros pre-definidos no arquivo data.sql, que está
representado na estrutura a baixo.

````
🗂️ src/
├── 📂 main/
│   └── 📂 resources/
│       └── 📝 data.sql
````

<br/><h2 align="left">Ambiente remoto</h2>
<ul>
    <li> URL:  https://sicredi.onrender.com/swagger-ui/index.html </li>
    <li> Obs.: Por ser um ambiente free tem limite de memória e CPU e só mantem a aplicação no Ar por 15 min. Recomendado testar a aplicação local. </li>
</ul>

<br/><h2 align="left">Funcionalidades</h2>

<p>Estrutura dos endpoints:</p>

![estrutura](https://github.com/uczak/sicredi/blob/main/src/main/resources/static/endpoints.PNG)


<ul>
    <li> Operaçõs de Produto </li>
    <ul>
        <li> Permite incluir um novo Produto. </li>
        <li> Consultar um Produto pelo ID. </li>
        <li> Listar todos os Produto sem paginação. </li>
        <li> Para cadastrar um Produto é necessário informa o nome do Produto e o valor unitário seguindo as seguinstes regras: </li>
        <ul>
            <li> Campo NOME: Campo <b>obrigatório</b> e deve ter entre 3 e 100 caracteres. </li>
            <li> Campo VALOR: Campo <b>obrigatório</b> e o valor deve ser maior que zero. </li>
        </ul>
    </ul>
    <li> Operaçõs de Pessoa </li>
    <ul>
        <li> Permite incluir uma nova pessoa. </li>
        <li> Consultar um pessoa pelo CPF. </li>
        <li> Listar todas as pessoas sem paginação. </li>
        <li> Para cadastrar um Pessoa é necessário informa o NOME e o CPF seguindo as seguinstes regras: </li>
        <ul>
            <li> Campo CPF: Campo <b>obrigatório</b> e deve estar no formato "000.000.000-00". </li>
            <li> Campo NOME: Campo <b>obrigatório</b> e deve ter entre 3 e 100 caracteres. </li>
        </ul>
    </ul>
    <li> Relatório de compra </li>
    <ul>
        <li> Permite consultar as compras diárias agrupadas por produto. Vai gerar um arquivo PRF. </li>
    </ul>
    <li> Operações de compra </li>
    <ul>
        <li> Permite cadastrar uma compra informando o CPF de uma pessoa previamente cadastrada e uma lista de Produtos tambem previamente cadastrados fomforme o exemplo a baixo. </li>
        <li> Consultar as compras seguindo o seguinte filtro: </li>
        <ul>
            <li> Campo NOME: Campo <b>obrigatório</b> e deve ter entre 3 e 100 caracteres. </li>
            <li> Campo CPF: Campo <b>obrigatório</b> e deve estar no formato "000.000.000-00". </li>
            <li> Campo DATA_INICIAL: Campo <b>obrigatório</b> e deve estar no formato "yyyy-MM-dd HH:mm:ss.SSS". </li>
            <li> Campo DATA_FINAL: Campo <b>obrigatório</b> e deve estar no formato "yyyy-MM-dd HH:mm:ss.SSS". </li>
        </ul>
    </ul>
</ul>

Exemplo de cadastro de compra:
````
{
  "cpf": "037.000.300-91",
  "produtos": [
    {
      "produtoId": 1,
      "quantidade": 3
    },
    {
      "produtoId": 2,
      "quantidade": 1
    },
    {
      "produtoId": 4,
      "quantidade": 1
    }
  ]
}
````


<p>Modelo de relatório emitido pela aplicação:</p>

![relatorio](https://github.com/uczak/sicredi/blob/main/src/main/resources/static/relatorio.PNG)



<br/><h2 align="left">Rodar o projeto local</h2>
<p>Para rodar o projeto, siga os passos a baixo:</p>
<ul>
  <li>Execute o comando <b>'./gradlew build'</b> no terminal.</li>
  <li>Execute o comando <b>'./gradlew bootRun'</b> no terminal.</li>
</ul>  

<br/><h2 align="left">Rodar os testes</h2>
<ul>
  <li>Execute o comando <b>'./gradlew test'</b> no terminal.</li>
</ul>  
