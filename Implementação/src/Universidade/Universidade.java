package Universidade;
import java.util.ArrayList;

public class Universidade {
    private ArrayList <Curso> cursos;
    private ArrayList <Usuario> usuarios;
    public static void main(String [] args){
        System.out.println("Iniciando");
    }
    //  getters and setters
    //  Curso e Cursos
    protected ArrayList<Curso> getCursos() {
        return cursos;
    }
    protected void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    protected Curso getCurso(String nome){
        return new Curso();
    }
    protected void setCurso(Curso curso){}
    //  Usuário e Usuários
    protected ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    protected void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    protected Usuario getUsuario(String nome){
        return null;
    }
    protected void setUsuario(Usuario usuario){}  
    // Functions
    protected void addUsuario(Usuario usuario){}
    protected void addCurso(Curso curso){}
    
}
