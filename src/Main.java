import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 01
        Turma turma = new Turma();
        turma.adicionarAluno("João", new Aluno("João", 8.5));
        turma.adicionarAluno("Maria", new Aluno("Maria", 7.5));
        turma.adicionarAluno("Lucas", new Aluno("Lucas", 10));
        turma.adicionarAluno("Laura", new Aluno("Laura", 6.75));
        turma.adicionarAluno("Matheus", new Aluno("Matheus", 8.0));

        // 02
        System.out.println(turma.obterNotaAluno("Maria"));
        System.out.println(turma.obterNotaAluno("Mario"));
        System.out.println(turma.obterAlunosComNotaMaiorQue(7.5));

        // 03
        System.out.println(turma.removerAlunosComNotaMenorQue(7));

        // 04
        Map<String, Aluno> alunosNotaDecrescente = turma.getAlunosNotaDecrescente();
        System.out.println("\n------Ordem decrescente de notas------");
        alunosNotaDecrescente.forEach((nome, aluno) -> {
            System.out.println(aluno.getNome() + " | " + aluno.getNota());
        });

        // 05
        Map<String, List<Aluno>> alunosFaixa = turma.agruparAlunosPorFaixa();
        System.out.println("\nAlunos por faixa de nota");
        alunosFaixa.forEach((faixa, alunos) -> {
            System.out.println("\n------Faixa " + faixa + "------");

            alunos.forEach(aluno -> System.out.println(aluno.getNome() + " | " + aluno.getNota()));
        });
    }
}