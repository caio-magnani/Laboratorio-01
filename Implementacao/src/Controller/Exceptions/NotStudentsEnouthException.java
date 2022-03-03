package Controller.Exceptions;

public class NotStudentsEnouthException extends Exception{
    public NotStudentsEnouthException(){
        super("Não há Alunos o minimo de 3 alunos para a universidade.Disciplina ocorrer");
    }
}
