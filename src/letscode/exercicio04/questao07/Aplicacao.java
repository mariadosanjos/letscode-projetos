package letscode.exercicio04.questao07;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o nome e idade de 5 pessoas");
        for(int i = 0; i<5; i++) {
            System.out.println("Nome: ");
            String nome = teclado.nextLine();
            System.out.println("Idade: ");
            int idade = Integer.parseInt(teclado.nextLine());
            Fachada.adicionarPessoas(nome, idade);
        }
        teclado.close();

        System.out.println("Pessoa mais nova: " + Fachada.retornarPessoaMaisNova().getNome());
        System.out.println("Pessoa mais velha: " + Fachada.retornarPessoaMaisVelha().getNome());
        System.out.println("Média das idades: " + Fachada.retornarMediaDeIdade());
    }
}
