package universidade;

import universidade.usuarios.Aluno;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Disciplina implements Serializable {
    private String nome;
    private boolean eObrigatoria;
    private boolean eAtiva;
    private List<Aluno> alunosMatriculados;

    public Disciplina(String nome, boolean eObrigatoria) {
        this.nome = nome;
        this.eObrigatoria = eObrigatoria;
        alunosMatriculados = new LinkedList<Aluno>();
    }

    public String toString() {
        return "Nome da disciplina: " + nome +
                " / " + (eObrigatoria ? " obrigatória " : " optativa ") +
                " / " + (eAtiva ? " está ativa." : " não está ativa.");
    }

    public String getNome() {
        return nome;
    }

    public void matricularAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
        if (alunosMatriculados != null && alunosMatriculados.size() > 3) seteAtiva(true);
        else seteAtiva(false);
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public boolean iseAtiva() {
        return eAtiva;
    }

    public void seteAtiva(boolean eAtiva) {
        this.eAtiva = eAtiva;
    }

    public void cancelarMatriculaAluno(Aluno aluno) {
        alunosMatriculados.remove(aluno);
    }

    public boolean iseObrigatoria() {
        return eObrigatoria;
    }

    public void seteObrigatoria(boolean eObrigatoria) {
        this.eObrigatoria = eObrigatoria;
    }

    public void editarDisciplina() {
    }
}
