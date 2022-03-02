package Controller.Usuarios;

public class Secretaria extends Usuario{

    public Secretaria(String nome, String login, String senha) {
        super(nome, login, senha, Enum.Secretaria);
    }
    
}
