package Controller;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nome;
    private List<Oferta> ofertas;

    public Materia(String nome, List<Oferta> ofertas) {
        this.nome = nome;
        this.ofertas = ofertas;
    }

    public Materia(String nome) {
        this.nome = nome;
        this.ofertas = new ArrayList<Oferta>();
    }

    public String getNome() {
        return this.nome;
    }

    public String ofertasToString() {
        String string = new String();
        for (Oferta oferta : ofertas) {
            string += oferta.toString() +"\n";
        }
        return string;
    }

    public void addOferta(Oferta oferta){
        this.ofertas.add(oferta);
    }
}
