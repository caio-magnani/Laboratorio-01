package Controller;

import java.util.List;

public class Universidade {
    private List<Usuario> usuarios;
    private List<Graduacao> cursos;
    
    public void addUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public void addCurso(Graduacao curso){
        this.cursos.add(curso);
    }

    public void novoSimestre(){}
}
