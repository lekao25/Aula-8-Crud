package siga;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AlunoDAO dao = new AlunoDAOMemoria();
        ServicoAluno servico = new ServicoAluno(dao);

        System.out.println("=== Cadastro de alunos ===");
        try {
            servico.cadastrar(new Aluno("João Pedro", "2026001", 8.5));
            servico.cadastrar(new Aluno("Ana Clara", "2026002", 7.0));
            System.out.println("Alunos cadastrados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }

        System.out.println("\n=== Tentativa de matrícula duplicada ===");
        try {
            servico.cadastrar(new Aluno("Outro Nome", "2026001", 6.0));
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }

        System.out.println("\n=== Listagem de alunos ===");
        List<Aluno> alunos = servico.listarTodos();
        for (Aluno a : alunos) {
            System.out.println(a);
        }

        System.out.println("\n=== Consulta por matrícula ===");
        try {
            Aluno encontrado = servico.consultar("2026001");
            System.out.println("Encontrado: " + encontrado);
        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }

        System.out.println("\n=== Alteração de aluno ===");
        try {
            servico.alterar(new Aluno("João Pedro Silva", "2026001", 9.0));
            System.out.println("Aluno alterado: " + servico.consultar("2026001"));
        } catch (Exception e) {
            System.out.println("Erro ao alterar: " + e.getMessage());
        }

        System.out.println("\n=== Exclusão de aluno ===");
        try {
            servico.excluir("2026002");
            System.out.println("Aluno 2026002 excluído com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }

        System.out.println("\n=== Tentativa de excluir matrícula inexistente ===");
        try {
            servico.excluir("9999999");
        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }

        System.out.println("\n=== Listagem final ===");
        for (Aluno a : servico.listarTodos()) {
            System.out.println(a);
        }
    }
}
