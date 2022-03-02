package Controller;

import java.util.List;

public class Materia {
    private String nome;
    private List<Oferta> ofertas;

    public Materia(String nome, List<Oferta> ofertas) {
        this.nome = nome;
        this.ofertas = ofertas;
    }

    public void addOferta(Oferta oferta){
        this.ofertas.add(oferta);
    }
}
