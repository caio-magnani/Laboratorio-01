package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.Usuarios.Professor;

public class Oferta {
    private String materia;
    private String mesAnoId;
    private float preco;
    private List<Professor> professores;
    private List<Matricula> matriculas;

    public Oferta(String materia, String mesAnoId, float preco, List<Professor> professores, List<Matricula> matriculas){
        this.materia = materia;
        this.mesAnoId = mesAnoId;
        this.preco = preco;
        this.professores = professores;
        this.matriculas = matriculas;
    }

    public Oferta(String materia, String mesAnoId, float preco){
        this.materia = materia;
        this.mesAnoId = mesAnoId;
        this.preco = preco;
        this.professores =new ArrayList<Professor>();
        this.matriculas =new ArrayList<Matricula>();
    }
    
    public String getMateria() {
        return materia;
    }
    
    public float getPreco() {
        return preco;
    }

    public String getName(){
        return this.materia+" - "+this.mesAnoId;
    }

    public void addProfessor(Professor professor) {
        this.professores.add(professor);
    }
    
    public void addMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
    }

    @Override
    public String toString() {
        String string = new String("Oferta: ");
        string += this.getName();
        string += "\n Ensinada pelos professores: ";
        for (Professor professor : professores) {
            string += "\n->" + professor.toString();
        }
        return string;
    }
}
