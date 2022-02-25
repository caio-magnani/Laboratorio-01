package Universidade;

public class Curso {
    private String nome;
    private int creditos;
    private Semestre[] semestres;

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Semestre[] getSemestres() {
        return semestres;
    }
    public void setSemestres(Semestre[] semestres) {
        this.semestres = semestres;
    }

}
