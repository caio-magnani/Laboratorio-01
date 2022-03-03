package Controller.Exceptions;

public class InvalidLoginOrPasswordException extends Exception{
    public InvalidLoginOrPasswordException(){
        super("Seu login ou sua senha estam errados");
    }
}
