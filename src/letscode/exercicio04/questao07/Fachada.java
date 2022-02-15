package letscode.exercicio04.questao07;

import java.util.ArrayList;

public class Fachada {
    private static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public static void adicionarPessoas(String nome, int idade) {
        pessoas.add(new Pessoa(nome,idade));
    }

    public static Pessoa retornarPessoaMaisNova() {
        int idadeMaisNova = Integer.MAX_VALUE;
        Pessoa pessoaMaisNova = null;
        for (Pessoa pessoa:pessoas) {
            if (pessoa.getIdade() < idadeMaisNova) {
                idadeMaisNova = pessoa.getIdade();
                pessoaMaisNova = pessoa;
            }
        }

        return pessoaMaisNova;

    }

    public static Pessoa retornarPessoaMaisVelha() {
        int idadeMaisVelha = Integer.MIN_VALUE;
        Pessoa pessoaMaisVelha = null;
        for (Pessoa pessoa:pessoas) {
            if (pessoa.getIdade() > idadeMaisVelha) {
                idadeMaisVelha = pessoa.getIdade();
                pessoaMaisVelha = pessoa;
            }
        }

        return pessoaMaisVelha;

    }

    public static double retornarMediaDeIdade() {
        int somaIdades = 0;
        for (Pessoa pessoa:pessoas) {
            somaIdades += pessoa.getIdade();
        }

        return somaIdades/pessoas.size();

    }
}
