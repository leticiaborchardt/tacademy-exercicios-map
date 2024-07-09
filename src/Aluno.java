public class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getFaixaNota() {
        if (nota >= 9.0) {
            return "A";
        } else if (nota >= 8.0) {
            return "B";
        } else if (nota >= 7.0) {
            return "C";
        } else if (nota >= 6.0) {
            return "D";
        }

        return "F";
    }
}
