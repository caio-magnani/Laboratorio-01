package universidade.usuarios;

import universidade.Disciplina;
import dados.Helper;
import universidade.Universidade;

import java.util.Scanner;

public class Professor extends Usuario {

    public Professor(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public int getOpcoesUsuario(Scanner teclado, Universidade universidade) {
        System.out.println("1 - Deslogar");
        System.out.println("2 - Alunos matriculados por disciplina");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        System.out.println("==========================");
        executarOpcoeUsuario(opcao, teclado, universidade);
        return opcao;
    }

    @Override
    public void executarOpcoeUsuario(int opcao, Scanner teclado, Universidade universidade) {
        switch(opcao){
            case(1):
                universidade.deslogarUsuario();
                break;
            case(2):
                Disciplina disciplina = universidade.selecionarDisciplina(teclado, universidade);
                if(disciplina != null) Helper.imprimirLista(disciplina.getAlunosMatriculados());
                break;
        }
    }
}
