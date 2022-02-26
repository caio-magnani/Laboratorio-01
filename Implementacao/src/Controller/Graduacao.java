package Controller;

import java.util.List;

public class Graduacao {
    private List<Materia> gradeCurricular;

    public Graduacao(List<Materia> gradeCurricular) {
        this.gradeCurricular=gradeCurricular;
    }
    
    public String getCurriculo() {
        String curriculo = "";
        for (Materia materia : gradeCurricular) {
            curriculo+= materia.toString() + "\n";
        }
        return curriculo;
    }    
}
