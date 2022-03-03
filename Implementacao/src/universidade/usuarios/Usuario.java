package universidade.usuarios;
import Controller.Exceptions.InvalidLoginOrPasswordException;
import universidade.Universidade;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Usuario implements Serializable {
    private String nome;
    private String login;
    private String senha;
    private boolean estaLogado;
    private Enum tipo = Enum.Usuario;

    public Usuario(String nome, String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
    }

    public Enum login(String login, String senha) throws InvalidLoginOrPasswordException {
        if (this.login.equals(login) && this.senha.equals(senha)) {
            return this.tipo;
        } else throw new InvalidLoginOrPasswordException();
    }

    public String toString() {
        return "nome: " + nome + ", login: " + login;
    }

    public String getLogin() {
        return login;
    }

    public Object getSenha() {
        return senha;
    }

    public void logar(){
        estaLogado = true;
    }

    public void deslogar(){
        estaLogado = false;
    }

    public abstract int getOpcoesUsuario(Scanner teclado, Universidade universidade);

    public abstract void executarOpcoeUsuario(int opcao, Scanner teclado, Universidade universidad);
}