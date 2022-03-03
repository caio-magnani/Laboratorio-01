import dados.Dados;
import dados.Helper;
import universidade.Universidade;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Universidade universidade = new Universidade();
        Scanner teclado = new Scanner(System.in);
        int opcao;

        do {
            opcao = universidade.alguemLogado() ?
                    universidade.getUsuarioLogado().getOpcoesUsuario(teclado, universidade)
                    : menuDeslogado(universidade, teclado);
        } while (opcao != 0);
        System.out.println("Até a próxima");
    }

    public static String getLogin(Scanner teclado) {
        System.out.println("Digite o login: ");
        String login = teclado.nextLine();
        return login;
    }

    public static String getNome(Scanner teclado) {
        System.out.println("Digite o nome: ");
        String nome = teclado.nextLine();
        return nome;
    }

    public static String getSenha(Scanner teclado) {
        System.out.println("Digite a senha: ");
        String senha = teclado.nextLine();
        return senha;
    }

    public static int menuCriacaoUsuario(Scanner teclado) {
        System.out.println("Escolha qual o tipo de usuario a ser criado");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("3 - Secretaria");
        System.out.println("0 - Voltar");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        return opcao;
    }

    public static int menuDeslogado(Universidade universidade, Scanner teclado) {
        System.out.println("Escolha dentre as opções abaixo:");
        System.out.println("1 - Logar");
        System.out.println("2 - Listar usuários");
        System.out.println("3 - Adicionar usuário");
        System.out.println("4 - Listar disciplinas");
        System.out.println("0 - Sair");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        System.out.println("==========================");
        executarOpcaoMenu(universidade, opcao, teclado);
        return opcao;
    }

    public static void executarOpcaoMenu(Universidade universidade, int opcao, Scanner teclado) {
        String login, senha;
        switch (opcao) {
            case 1:
                if (!universidade.alguemLogado()) {
                    login = getLogin(teclado);
                    senha = getSenha(teclado);
                    universidade.logarUsuario(login, senha);
                } else {
                    universidade.deslogarUsuario();
                }
                break;
            case 2:
                Helper.imprimirLista(universidade.getUsuarios());
                break;
            case 3:
                int opcaoUsuario = menuCriacaoUsuario(teclado);
                String nome = getNome(teclado);
                login = getLogin(teclado);
                senha = getSenha(teclado);
                universidade.criarUsuario(opcaoUsuario, nome, login, senha);
                break;
            case 4:
                Helper.imprimirLista(universidade.getDisciplinas());
                break;
            case 0:
                Dados.salvarArquivos(universidade);
                break;
        }
    }
}

//          - Colocar alterações na secretaria
//          - Colocar classe de oferta
//        testes
//        o que acontece se o usuário não digita inteiros