package Controller.Usuarios;

public class Professor extends Usuario{

    public Professor(String nome, String login, String senha) {
        super(nome, login, senha, Enum.Professor);
    }

}
