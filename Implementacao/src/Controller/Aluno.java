package Controller;

public class Aluno extends Usuario{

    public Aluno(String nome, String login, String senha) {
        super(nome, login, senha, Enum.Aluno);
    }
}
