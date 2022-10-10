# Receita Sincronização
<a href="https://github.com/flavio-becker/receitasincronizacao/blob/main/LICENSE"><img alt="GitHub license" src="https://img.shields.io/github/license/flavio-becker/receitasincronizacao"></a>

# Sobre o projeto
O projeto tem como objetivo a simulação da Sincronização de contas bancarias enviadas em um arquivo CSV para a Receita Federal afim de valida-las.

Esse projeto na branch main é referente a uma aplicação Standalone. Caso você queira rodar como uma API o codigo está na branch API_receitasincronizacao.

## Back end
* Java
* Spring Boot
* Maven
* Documentação Swagger


# Como executar o projeto

Pré-requisitos: Java 11

```bash
  # Clonar repositório
  git clone https://github.com/flavio-becker/receitasincronizacao
  
  # entrar na pasta do projeto
  cd sincronizacaoreceita
  
  # executar o projeto
  ./mvn spring-boot:run
```  
  
  # Documentação
  Após rodar o projeto é possivel ler a documentação em: localhost:8080/q/swagger-ui
  
  
  # Instrução de uso
  
  Após executar o projeto:
  
    
  1 - Criar uma pasta na onde será adiciona o arquivo csv com asd contas para validação. Exemplo: (C:\VerificacaoReceita)
  
  2 - Utilizar o arquivo de exemplo no link abaixo respeitando a posição das colunas e seu cabeçalho.   
  https://github.com/flavio-becker/receitasincronizacao/blob/main/assets/Contas.csv
  
  3 - Salvar o arquivo csv com os dados a serem validados com o mesmo nome "Contas" dentro da pasta criada. No nosso exemplo (C:\VerificacaoReceita)
  
  4 - Rodar o projeto. Aparecerá uma tela conforme a imagem abaixo.
  
  ![Alt text](https://github.com/flavio-becker/receitasincronizacao/blob/main/assets/tela.PNG?raw=true "Title")
  
  5 - Inserir a pasta onde o arquivo de contas a serem validadas está e clicar no botão "Validar". Exemplo: (C:\VerificacaoReceita)
  
  6 - Após a execução será exibido uma mensagem informando se a validação ocorreu com sucesso ou não.
  
  7 - O Arquivo validado estará na pasta informada, junto com o arquivo Contas.csv, com o nome ContasVerificadas.csv
  
  
  # Autor
  Flávio Becker
  
  https://www.linkedin.com/in/flavio-becker-1ab63017/
