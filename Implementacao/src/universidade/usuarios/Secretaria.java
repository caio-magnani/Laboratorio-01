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

    private void listarUsuario(Universidade universidade) {
        System.out.println("Lista de Usuário :");
        for (Usuario usuario : universidade.getUsuarios()) {
            System.out.println(usuario.toString());
        }
    }

    private void criarUsuario(Universidade universidade, Scanner teclado) {
        System.out.println("Digite o tipo do usuário:");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("3 - Secretaria");
        int opcao = Integer.parseInt(teclado.nextLine());
        System.out.println("Digite o nome do usuário");
        String nome = teclado.nextLine();
        System.out.println("Digite o login do usuário");
        String login = teclado.nextLine();
        System.out.println("Digite a senha do usuário");
        String senha = teclado.nextLine();
        this.criarUsuario(opcao, nome, login, senha, universidade);
    }

    private void atualizarUsuario(Universidade universidade, Scanner teclado) {
        System.out.println("Digite o nome do usuário que deseja editar");
        String nome = teclado.nextLine();
        Usuario antigo = null;
        for (Usuario usuario : universidade.getUsuarios()){
            if(nome.equals(usuario.getNome()))
            antigo=usuario;
        }
        try{
            if(universidade.getUsuarios().remove(antigo)){
                System.out.println("Digite o tipo do usuário:");
                System.out.println("1 - Aluno");
                System.out.println("2 - Professor");
                System.out.println("3 - Secretaria");
                int opcao = Integer.parseInt(teclado.nextLine());
                System.out.println("Digite o nome do usuário");
                nome = teclado.nextLine();
                System.out.println("Digite o login do usuário");
                String login = teclado.nextLine();
                System.out.println("Digite a senha do usuário");
                String senha = teclado.nextLine();
                UsuarioFactory usuarioFactory = new UsuarioFactory();
                Usuario usuario = usuarioFactory.getUsuario(opcao, nome, login, senha);
                universidade.getUsuarios().add(usuario);
            }
            else{
                System.out.println("Este usuário não foi encontrado. Tente novamente listado os usuários. Opção 3");
            }
        }
        catch(NullPointerException e){
            System.out.println("Este usuário não foi encontrado. Tente novamente listado os usuários. Opção 3");
        }
    }
    
    public void criarUsuario(int opcao, String nome, String login, String senha, Universidade universidade) {
        if (universidade.encontrarUsuarioPeloLogin(login) == null) {
            UsuarioFactory usuarioFactory = new UsuarioFactory();
            Usuario usuario = usuarioFactory.criarUsuario(opcao, nome, login, senha);
            universidade.getUsuarios().add(usuario);
            System.out.println("Usuario criado");
            System.out.println("==========================");
        } else {
            System.out.println("Já existe um usuário com esse login");
            System.out.println("==========================");
        }
    }

    private void deletarUsuario(Universidade universidade, Scanner teclado) {
        System.out.println("Digite o nome do usuário que deseja deletar");
        String nome = teclado.nextLine();
        Usuario antigo = null;
        for (Usuario usuario : universidade.getUsuarios()){
            if(nome.equals(usuario.getNome()))
            antigo=usuario;
        }
        try{
            if(universidade.getUsuarios().remove(antigo)){
                System.out.println("Usuario deletado com sucesso");
            }
            else{
                System.out.println("Este usuário não foi encontrado. Tente novamente listado os usuários. Opção 3");
            }
        }
        catch(NullPointerException e){
            System.out.println("Este usuário não foi encontrado. Tente novamente listado os usuários. Opção 3");
        }
    }

    private void gerarCurriculo(Universidade universidade,Scanner teclado) {
        System.out.println("Escolha o curso que quer gerar o Curriculo ?");
        try{
            for (int i=0;i<universidade.getCursos().size();i++){
                System.out.println(i + " - " + universidade.getCursos().get(i).getNome());
            }
            int opcao = Integer.parseInt(teclado.nextLine());
            this.gerarCurriculo(universidade.getCursos().get(opcao));
        }
        catch(NullPointerException e){
            System.out.println("Não ah nenhum curso criado ainda");
        }

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
        System.out.println("3 - Listar Usuários");
        System.out.println("4 - Editar Usuário");
        System.out.println("5 - Adicionar Usuário");
        System.out.println("6 - Excluir Usuário");
        System.out.println("7 - Gerar Curriculo");
        System.out.println("8 - " + (universidade.isePeriodoDeMatricular() ?
                "Desabilitar período de Matriculas"
                : "Habilitar período de Matriculas")
        );
        System.out.println("9 - Adicionar disciplina");
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
            case 3:
                this.listarUsuario(universidade);
                break;
            case 4:
                this.atualizarUsuario(universidade, teclado);
                break;
            case 5:
                this.criarUsuario(universidade, teclado);
                break;
            case 6:
                this.deletarUsuario(universidade, teclado);
                break;
            case 7:
                this.gerarCurriculo(universidade, teclado);
                break;
            case 8:
                universidade.setePeriodoDeMatricular(!universidade.isePeriodoDeMatricular());
                break;
            case 9:
                disciplina = getDadosDisciplina(teclado);
                universidade.adicionarDisciplina(disciplina);
                break;
        }
    }
}
