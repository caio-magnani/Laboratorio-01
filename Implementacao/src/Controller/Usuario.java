package Controller;

import Controller.Exceptions.InvalidLoginOrPasswordException;

public abstract class Usuario {
    private String nome;
    private String login;
    private String senha;
    private boolean estaLogado;
    private Enum tipo;

// Construtor

    public Usuario (String nome, String login, String senha, Enum tipo){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

// Get

    public String getNome() {
        return nome;
    }
    
    public String getTipo() {
        return tipo.getTipo();
    }

    public boolean estaLogado(){
        return this.estaLogado;
    }

// Metodos

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

// Overrides

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