package Controller.Usuarios;

import Controller.Exceptions.InvalidLoginOrPasswordException;

public abstract class Usuario {
    private String nome;
    private String login;
    private String senha;
    private boolean estaLogado;
    private Enum tipo;

    public Usuario (String nome, String login, String senha, Enum tipo){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }
    
    public String getTipo() {
        return tipo.getTipo();
    }

    public boolean estaLogado(){
        return this.estaLogado;
    }

    public void login(String login, String senha) throws InvalidLoginOrPasswordException{
        if(this.login.equals(login) && this.senha.equals(senha)){
            this.estaLogado=true;
            System.out.println("System Responder >> Login Efetuado");
        }
        else throw new InvalidLoginOrPasswordException();
    }
    public void logout(){
        this.estaLogado = false;
        System.out.println("System Responder >> Logout Efetuado");
    }

    @Override
    public String toString(){
        String usuario = "---------------------------------------------\n";
        usuario += tipo.name()+" : "+this.nome+"\n";
        usuario += "Ele está Logado ? "+this.estaLogado()+"\n";
        usuario += "É um usuario do tipo "+this.tipo.name()+"\n";
        usuario += "---------------------------------------------";
        return usuario;
    }
}