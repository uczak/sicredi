<h1 align="center">Projeto</h1>
<p align="center">Este projeto sobe um banco H2 em memoria para o armazenamento dos dados. Foi desenvolvido com Java - Spring Boot.</p>


<br/><h2 align="left">Tecnologias</h2>
<ul>
  <li>Java 17</li>
  <li>Spring boot 2.7.11</li>
  <li>Gradlew 7.6</li>
</ul>

<br/><h2 align="left">Estrutura de dados</h2>

<p>Estrutura de dados criada para relacionar produtos, pessoas e compras.</p>
![Diagrama ER](https://github.com/uczak/sicredi/blob/main/src/main/resources/static/DiagramaER.PNG)

Ao subir a aplicação o banco H2 sera criado com alguns pre definidos no arquivo data.sql, representado na estrutura a baixo.
```txt
🗂️ src/
├── 📂 main/
│   └── 📂 resources/
│       └── 📝 data.sql

````


<br/><h2 align="left">Ambiente remoto</h2>
<ul>
  <li> U:  https://gitlab.rbs.com.br/rbsdev/config-files</li>
</ul>

<br/><h2 align="left">Rodar o projeto local </h2>
<p>Para rodar o projeto, siga os passos a baixo:</p>
<ul>
  <li>Execute o comando <b>'./gradlew build'</b> no terminal.</li>
  <li>Execute o comando <b>'./gradlew bootRun'</b> no terminal.</li>
</ul>  

<br/><h2 align="left">Rodar o teste</h2>
<ul>
  <li>Execute o comando <b>'./gradlew test'</b> no terminal.</li>
</ul>  
