## Descrição
Este projeto implementa o CRUD completo (cadastrar, consultar, listar, alterar e excluir)
da entidade Aluno, utilizando as camadas de entidade, acesso a dados (DAO) e serviço,
com validações centralizadas e tratamento de exceções.

## Estrutura do projeto
src/siga/ ├── Aluno.java ├── AlunoDAO.java ├── AlunoDAOMemoria.java ├── ServicoAluno.java └── Main.java

## Como compilar
Na raiz da pasta `aula-08-crud`, execute:

```bash
javac -d out src/siga/*.java
java -cp out siga.Main
