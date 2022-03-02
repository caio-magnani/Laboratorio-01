package Controller;

import java.util.ArrayList;
import java.util.List;

public class Graduacao {
    private String nome;
    private List<Materia> gradeCurricular;

    public Graduacao(String nome, List<Materia> gradeCurricular) {
        this.gradeCurricular=gradeCurricular;
    }
    public Graduacao (String nome){
        gradeCurricular = new ArrayList<Materia>();
    }
    
    public String getNome() {
        return this.nome;
    }

    public void addMateria(Materia materia){
        this.gradeCurricular.add(materia);
    }
    
    public String gerarCurriculo() {
        String curriculo = ""+this.nome;
        for (Materia materia : gradeCurricular) {
            curriculo += materia.getNome() + "\n";
        }
        return curriculo;
    }
    
    
}
