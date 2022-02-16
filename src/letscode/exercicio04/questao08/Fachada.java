package letscode.exercicio04.questao08;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Fachada {
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void adicionarPessoas(String nome, double peso, double altura) {
        pessoas.add(new Pessoa(nome, peso, altura));
    }

    public static void exibirPessoasForaPesoIdeal() {
        for (Pessoa pessoa:pessoas) {
            if (pessoa.getImc() < 18.5 || pessoa.getImc() > 25) {
                System.out.println("Nome: " + pessoa.getNome() + " IMC: " + formatarImc(pessoa.getImc()));
            }
        }
    }

    private static String formatarImc(double imc) {
        DecimalFormat df = new DecimalFormat("##.##");
        return df.format(imc);
    }

}
