package Controller.Exceptions;

public class InvalidPermitionException extends Exception{
    public InvalidPermitionException(){
        super("Você não tem a permissão necessaria. Pessa ajuda a Secretaria");
    }
}
