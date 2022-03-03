package universidade.usuarios;

import dados.Helper;
import universidade.Curso;
import universidade.Disciplina;
import universidade.Universidade;

import java.util.Scanner;

public class Secretaria extends Usuario {

    public Secretaria(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    private Usuario consultarUsuario(String nome) {
        return null;
    }

    private void criarUsuario() {
    }

    private void atualizarUsuario() {
    }

    private void deletarUsuario() {
    }

    private String gerarCurriculo(Curso curso) {
        return new Curso().toString();
    }

    private Disciplina getDadosDisciplina(Scanner teclado){
        String nome = Helper.getNomeDisciplina(teclado);
        return new Disciplina(nome, false);
    }

    @Override
    public int getOpcoesUsuario(Scanner teclado, Universidade universidade) {
        System.out.println("1 - Deslogar");
        System.out.println("2 - Editar disciplinas");
        System.out.println("3 - Editar alunos");
        System.out.println("4 - Editar professores");
        System.out.println("5 - " + (universidade.isePeriodoDeMatricular() ?
                "Desabilitar período de Matriculas"
                : "Habilitar período de Matriculas")
        );
        System.out.println("6 - Adicionar disciplina");
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
            case 1:
                universidade.deslogarUsuario();
                break;
            case 2:
                disciplina = universidade.selecionarDisciplina(teclado, universidade);
                if (disciplina != null) disciplina.editarDisciplina();
                break;
            case 5:
                universidade.setePeriodoDeMatricular(!universidade.isePeriodoDeMatricular());
                break;
            case 6:
                disciplina = getDadosDisciplina(teclado);
                universidade.adicionarDisciplina(disciplina);
                break;
        }
    }
}
