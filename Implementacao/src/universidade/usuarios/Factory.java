package universidade.usuarios;

public abstract class Factory<T> {

    public T criarUsuario(int choice, String nome, String login, String senha){
        T obj = this.getUsuario(choice, nome, login, senha);
        return obj;
    }

    public abstract T getUsuario(int choice, String nome, String login, String senha);
}
