import java.util.*;
import java.util.stream.Collectors;

public class Turma {
    private Map<String, Aluno> alunos = new HashMap<String, Aluno>();

    public double obterNotaAluno(String nomeAluno) {
        try {
            if (this.getAlunos().containsKey(nomeAluno)) {
                return this.getAlunos().get(nomeAluno).getNota();
            }

            throw new Exception("Não foi possível encontrar o aluno " + nomeAluno + " na lista.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public List<String> obterAlunosComNotaMaiorQue(double nota) {
        return this.getAlunos().entrySet().stream()
                .filter(entry -> entry.getValue().getNota() > nota)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> removerAlunosComNotaMenorQue(double nota) {
        List<String> alunos = this.getAlunos().entrySet().stream()
                .filter(entry -> entry.getValue().getNota() < nota)
                .map(Map.Entry::getKey)
                .toList();

        alunos.forEach(aluno -> this.getAlunos().remove(aluno));

        return alunos;
    }

    public Map<String, Aluno> getAlunosNotaDecrescente() {
        return this.getAlunos().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingDouble(Aluno::getNota).reversed()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (aluno1, aluno2) -> aluno1,
                        LinkedHashMap::new));
    }

    public Map<String, List<Aluno>> agruparAlunosPorFaixa() {
        return this.getAlunos().values()
                .stream()
                .collect(Collectors.groupingBy(Aluno::getFaixaNota));
    }

    public void adicionarAluno(String nome, Aluno aluno) {
        this.getAlunos().put(nome, aluno);
    }

    public Map<String, Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Map<String, Aluno> alunos) {
        this.alunos = alunos;
    }
}
