package Controller;

import Controller.Exceptions.InvalidLoginOrPasswordException;

public abstract class Usuario {
    private String nome;
    private String login;
    private String senha;
    private Enum tipo = Enum.Usuario;

    public Enum login(String login, String senha) throws InvalidLoginOrPasswordException{
        if(this.login.equals(login) && this.senha.equals(senha)){
            return this.tipo;
        }
        else throw new InvalidLoginOrPasswordException();
    }
    
    public String toString(){
        String usuario = tipo.name()+" : "+this.nome+"\n";
        return usuario;
    }
}