# Receita Sincronização
<a href="https://github.com/flavio-becker/receitasincronizacao/blob/main/LICENSE"><img alt="GitHub license" src="https://img.shields.io/github/license/flavio-becker/receitasincronizacao"></a>

# Sobre o projeto
O projeto tem como objetivo a simulação da Sincronização de contas bancaria enviadas em um arquivo CSV para a Receita Federal afim de valida-las.


##Back end
* Java
* Spring Boot
* Maven
* Documentação Swagger


# Como executar o projeto

##Pré-requisitos: Java 11

...bash
  # Clonar repositório
  git clone https://github.com/flavio-becker/receitasincronizacao
  
  # entrar na pasta do projeto
  cd receita sincronizacaoreceita
  
  # executar o projeto
  ./mvn spring-boot:run
  ...
  
  
  # Documentação
  Após rodar o projeto é possivel ler a documentação em: localhost:8080/q/swagger-ui
  
  
  # Instrução de uso
  
  1 - Importar a collection abaixo para o postman
  Collection: https://github.com/flavio-becker/receitasincronizacao/tree/main/openapi
  
  2 - Criar uma pasta na raiz c: com o nome "VerificacaoReceita" (C:\VerificacaoReceita)
  
  3 - Utilizar o arquivo de exemplo no link abaixo respeitando a posição das colunas e seu cabeçalho.   
  https://github.com/flavio-becker/receitasincronizacao/blob/main/assets/Contas.csv
  
  4 - Salvar o arquivo csv com os dados a serem validados com o mesmo nome "Contas" dentro da pasta criada (C:\VerificacaoReceita)
  
  5 - Abrir o postman e executar a consulta (conforme collection do item 1).
