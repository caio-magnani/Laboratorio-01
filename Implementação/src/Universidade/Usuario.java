package Universidade;
public interface Usuario {
    public void logar();
    public void deslogar();
    public void reperarSenha();
    public String getNome();
    public String getTipo();
    public String toString();
    public boolean estaLogado();
}
