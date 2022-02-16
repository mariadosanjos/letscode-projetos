package letscode.exercicio04.questao08;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome, peso e altura de 5 pessoas");
        for(int i = 0; i<5; i++) {
            System.out.println("Nome: ");
            String nome = teclado.nextLine();
            System.out.println("Peso: ");
            double peso = Double.parseDouble(teclado.nextLine());
            System.out.println("Altura: ");
            double altura = Double.parseDouble(teclado.nextLine());
            Fachada.adicionarPessoas(nome, peso, altura);
        }
        teclado.close();

        System.out.println("Pessoas fora do peso ideal: ");
        Fachada.exibirPessoasForaPesoIdeal();
    }
}
