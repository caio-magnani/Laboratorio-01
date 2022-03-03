package dados;

import java.util.List;
import java.util.Scanner;

public class Helper {
    public static <T> void imprimirLista(List<T> lista) {
        System.out.println("Listagem abaixo (" + lista.size() + " items)");
        for (T object : lista) {
            if (object != null) System.out.println(object.toString());
        }
        System.out.println("==========================");
    }

    public static String getNomeDisciplina(Scanner teclado){
        System.out.println("Digite o nome da disciplina: ");
        return teclado.nextLine();
    }
}
