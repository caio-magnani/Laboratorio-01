package universidade;

import dados.Dados;
import universidade.usuarios.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static dados.Helper.getNomeDisciplina;

public class Universidade {
    private List<Usuario> usuarios;
    private List<Disciplina> disciplinas;
    private List<Curso> cursos;
    private Usuario usuarioLogado;
    private boolean ePeriodoDeMatricular;
    private SistemaCobranca sistemaCobranca;

    public Universidade() {
        usuarios = new LinkedList<Usuario>();
        disciplinas = new LinkedList<Disciplina>();
        sistemaCobranca = new SistemaCobranca();
        ePeriodoDeMatricular = false;
        /*
        usuarios.add(new Aluno("aluno1", "aluno1", "aluno1"));
        usuarios.add(new Secretaria("secretaria1", "secretaria1", "secretaria1"));
        usuarios.add(new Professor("professor1", "professor1", "professor1"));
        disciplinas.add(new universidade.Disciplina("disciplina1", true));
         */

        usuarioLogado = null;
        Dados.carregarDadosDosArquivos(usuarios, disciplinas);
        //atualizarCobranca(usuarios);
    }

    private void atualizarCobranca(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            Aluno aluno = (Aluno) usuario;
            if (aluno.isInscritoSemestre()) sistemaCobranca.adicionarAlunoInscrito((Aluno) usuario);
        }
    }

    public void criarUsuario(int opcao, String nome, String login, String senha) {
        if (encontrarUsuarioPeloLogin(login) == null) {
            UsuarioFactory usuarioFactory = new UsuarioFactory();
            Usuario usuario = usuarioFactory.criarUsuario(opcao, nome, login, senha);
            usuarios.add(usuario);
            System.out.println("Usuario criado");
            System.out.println("==========================");
        } else {
            System.out.println("Já existe um usuário com esse login");
            System.out.println("==========================");
        }
    }


    public void addCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public void novoSemestre() {
    }

    public void logarUsuario(String login, String senha) {
        Usuario usuario = encontrarUsuarioPeloLogin(login);
        if (usuario != null) {
            if (usuario.getSenha().equals(senha)) {
                usuario.logar();
                usuarioLogado = usuario;
                System.out.println("Logado");
                System.out.println("==========================");
            } else System.out.println("Senha inadequada.");
        }
    }

    public Usuario encontrarUsuarioPeloLogin(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) return usuario;
        }
        //System.out.println("Usuário não encontrado");
        System.out.println("==========================");
        return null;
    }

    public Disciplina encontrarDisciplina(String nomeDaDisciplina) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equals(nomeDaDisciplina)) return disciplina;
        }
        System.out.println("universidade.Disciplina não encontrada");
        System.out.println("==========================");
        return null;
    }

    public boolean alguemLogado() {
        return usuarioLogado != null;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void deslogarUsuario() {
        usuarioLogado.deslogar();
        usuarioLogado = null;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Disciplina selecionarDisciplina(Scanner teclado, Universidade universidade) {
        String nomeDaDisciplina = getNomeDisciplina(teclado);
        return universidade.encontrarDisciplina(nomeDaDisciplina);
    }

    public boolean isePeriodoDeMatricular() {
        return ePeriodoDeMatricular;
    }

    public void setePeriodoDeMatricular(boolean ePeriodoDeMatricular) {
        this.ePeriodoDeMatricular = ePeriodoDeMatricular;
    }

    public SistemaCobranca getSistemaCobranca() {
        return sistemaCobranca;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        System.out.println("Disciplina criada como optativa por padrão");
        System.out.println("==========================");
    }
}
