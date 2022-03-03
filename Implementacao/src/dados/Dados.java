package dados;

import universidade.Disciplina;
import universidade.Universidade;
import universidade.usuarios.Usuario;

import java.io.*;
import java.util.List;

public class Dados {
    static final String[] files = {"usuarios.dat", "disciplinas.dat"};

    private static <T> void carregarDados(List<T> lista, String arquivo, Class<T> className) {
        boolean finalDados = false;

        try {
            FileInputStream isDados = new FileInputStream(new File(arquivo));
            ObjectInputStream dados = new ObjectInputStream(isDados);
            do {
                try {
                    T lido = (T) dados.readObject();
                    lista.add(lido);
                } catch (EOFException var5) {
                    finalDados = true;
                }
            } while (!finalDados);
        } catch (FileNotFoundException var6) {
            System.out.println("Arquivo não encontrado; lista não criada");
        } catch (IOException var7) {
            System.out.println("Problema na stream; lista não criada");
        } catch (ClassNotFoundException var8) {
            var8.printStackTrace();
            System.out.println("Classe Usuario não encontrada no projeto");
        }
    }

    public static void carregarDadosDosArquivos(List<Usuario> usuarios, List<Disciplina> disciplinas) {
        carregarDados(usuarios, files[0], Usuario.class);
        carregarDados(disciplinas, files[1], Disciplina.class);
    }

    private static <T> void salvarDadosEmArquivo(List<T> lista, String arquivo) {

        try {
            FileOutputStream arqSaida = new FileOutputStream(new File(arquivo));
            ObjectOutputStream dadosSaida = new ObjectOutputStream(arqSaida);
            for (Object generic : lista) {
                dadosSaida.writeObject(generic);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não pode ser criado");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Problemas no uso da stream de gravação");
        }
    }

    public static void salvarArquivos(Universidade universidade) {
        salvarDadosEmArquivo(universidade.getUsuarios(), files[0]);
        salvarDadosEmArquivo(universidade.getDisciplinas(), files[1]);
    }
}
