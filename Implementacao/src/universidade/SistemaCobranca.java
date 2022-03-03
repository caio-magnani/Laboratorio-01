package universidade;

import universidade.usuarios.Aluno;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class SistemaCobranca implements Serializable {
    private List<Aluno> alunosInscritos;

    public SistemaCobranca() {
        this.alunosInscritos = new LinkedList<Aluno>();
    }

    public void adicionarAlunoInscrito(Aluno aluno){
        alunosInscritos.add(aluno);
    }
}
