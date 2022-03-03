package universidade.usuarios;

public class UsuarioFactory extends Factory<Usuario>{
    @Override
    public Usuario getUsuario(int choice, String nome, String login, String senha){
        switch(choice){
            case 1: return new Aluno(nome, login, senha);
            case 2: return new Professor(nome, login, senha);
            case 3: return new Secretaria(nome, login, senha);
        }
        return null;
    }
}
