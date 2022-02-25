package Universidade;

import java.util.ArrayList;

import javax.swing.UIDefaults.ProxyLazyValue;

public interface Disciplina {
    public String getName();
    public String getTipo();
    public Float getPreco();
    public ArrayList<Usuario> getAlunos();
    public void addAluno();
    
}
