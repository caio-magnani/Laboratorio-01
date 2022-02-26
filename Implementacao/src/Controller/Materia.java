package Controller;

import java.util.List;

public class Materia {
    private String nome;
    private List<Disciplina> ofertas;

    public Materia(String nome, List<Disciplina> ofertas) {
        this.nome = nome;
        this.ofertas = ofertas;
    }

    public void addOferta(Disciplina disciplina){
        this.ofertas.add(disciplina);
    }
}
