package universidade.usuarios;

import universidade.Disciplina;
import dados.Helper;
import universidade.Universidade;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Aluno extends Usuario {
    private List<Disciplina> disciplinas;
    private boolean inscritoSemestre;

    public Aluno(String nome, String login, String senha) {
        super(nome, login, senha);
        disciplinas = new LinkedList<>();
        inscritoSemestre = false;
    }

    private void cancelarMatricula(Disciplina d) {
        disciplinas.remove(d);
        d.cancelarMatriculaAluno(this);
        System.out.println("Cancelamento da matricula feito");
        System.out.println("==========================");
    }

    public Disciplina selecionarDisciplina(Scanner teclado) {
        String nomeDaDisciplina = Helper.getNomeDisciplina(teclado);
        return encontrarDisciplina(nomeDaDisciplina);
    }

    private Disciplina encontrarDisciplina(String nomeDaDisciplina) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equals(nomeDaDisciplina)) return disciplina;
        }
        System.out.println("universidade.Disciplina não encontrada");
        System.out.println("==========================");
        return null;
    }

    private void matricular(Disciplina d) {
        if (d.getAlunosMatriculados() == null || d.getAlunosMatriculados().size() < 60) {
            if (getQtdeObrigatorias() < 4 && getQtdeOptativas() < 2) {
                disciplinas.add(d);
                d.matricularAluno(this);
                System.out.println("Matricula feita");
                System.out.println("==========================");
            } else {
                System.out.println("O aluno já está inscrito em " + getQtdeOptativas() +
                        " optativas e em " + getQtdeObrigatorias() + " obrigatórias " +
                        "(limite de 2 e 4");
                System.out.println("==========================");
            }
        } else {
            System.out.println("A disciplina já está cheia");
            System.out.println("==========================");
        }
    }

    private long getQtdeObrigatorias() {
        return disciplinas.stream().filter(e -> e.iseObrigatoria()).count();
    }

    private long getQtdeOptativas() {
        return disciplinas.stream().filter(e -> !e.iseObrigatoria()).count();
    }

    private void inscreverSemestre(Universidade universidade) {
        inscritoSemestre = true;
        universidade.getSistemaCobranca().adicionarAlunoInscrito(this);
        System.out.println("Aluno inscrito para o semestre");
    }

    public boolean isInscritoSemestre() {
        return inscritoSemestre;
    }

    @Override
    public int getOpcoesUsuario(Scanner teclado, Universidade universidade) {
        System.out.println("1 - Deslogar");
        System.out.println("2 - Listar disciplinas do curso");
        System.out.println("3 - Listar disciplinas matriculadas");
        if (!inscritoSemestre) System.out.println("4 - Inscrever para o semestre");
        if (universidade.isePeriodoDeMatricular() && inscritoSemestre) {
            System.out.println("5 - Matricular em disciplina");
            System.out.println("6 - Cancelar matrícula em disciplina");
        }
        int opcao = teclado.nextInt();
        teclado.nextLine();
        System.out.println("==========================");
        executarOpcoeUsuario(opcao, teclado, universidade);
        return opcao;
    }

    @Override
    public void executarOpcoeUsuario(int opcao, Scanner teclado, Universidade universidade) {
        Disciplina disciplina;
        switch (opcao) {
            case (1):
                universidade.deslogarUsuario();
                break;
            case (2):
                Helper.imprimirLista(universidade.getDisciplinas());
                break;
            case (3):
                Helper.imprimirLista(disciplinas);
                break;
            case (4):
                inscreverSemestre(universidade);
                break;
            case (5):
                disciplina = universidade.selecionarDisciplina(teclado, universidade);
                if (disciplina != null) matricular(disciplina);
                break;
            case (6):
                disciplina = selecionarDisciplina(teclado);
                if (disciplina != null) cancelarMatricula(disciplina);
                break;
        }

    }
}

