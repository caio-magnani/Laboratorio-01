package universidade;

public class Curso {
    private String nome;
    private int noCreditos;
    private Disciplina[] disciplinas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNoCreditos() {
        return noCreditos;
    }

    public void setNoCreditos(int noCreditos) {
        this.noCreditos = noCreditos;
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }

}
