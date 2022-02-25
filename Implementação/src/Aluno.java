<<<<<<< HEAD
import java.util.ArrayList;

import Universidade.Disciplina;
import Universidade.Semestre;
import Universidade.Usuario;

public class Aluno implements Usuario{
    private ArrayList<Disciplina> disciplinas;

    private Aluno matricular(Disciplina d){    
        return this;
    }

    private Aluno inscreverSemestre(Semestre s){    
        return this;
    }

    private void inscreverDisciplina(Semestre s){    

    }

    private void cancelarMatricula(){    

    }

    @Override
    public void logar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deslogar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void reperarSenha() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getNome() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTipo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean estaLogado() {
        // TODO Auto-generated method stub
        return false;
    }
=======
public class Aluno extends Usuario{
    private Disciplina[] disciplinasObrigatorias;
    private Disciplina[] disciplinasOptativas;

    private void matricula(Disciplina d){

    }

    private void inscreverSemestre(Semestre s){

    }

    private void cancelarMatricula(){

    }
>>>>>>> parent of a84d2a4... atualizando implementacao com diagrama de classes
}
