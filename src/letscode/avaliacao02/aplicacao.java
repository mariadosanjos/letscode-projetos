package letscode.avaliacao02;

import java.util.*;
import java.util.stream.Collectors;

public class aplicacao {

    private static LeituraArquivo leituraArquivoAtriz;
    private static LeituraArquivo leituraArquivoAtor;
    private static List<Artista> atrizList;
    private static List<Artista> atorList;
    private static List<Artista> artistaList = new ArrayList<>();

    public static void main(String[] args) {

        leituraArquivoAtriz = new LeituraArquivoAtriz("C:\\Users\\maria\\IdeaProjects\\LetsCode-Projetos\\src\\letscode\\avaliacao02\\resources\\atriz.csv");
        leituraArquivoAtor = new LeituraArquivoAtor("C:\\Users\\maria\\IdeaProjects\\LetsCode-Projetos\\src\\letscode\\avaliacao02\\resources\\ator.csv");
        artistaList.addAll(leituraArquivoAtriz.getArtistas());
        artistaList.addAll(leituraArquivoAtor.getArtistas());
        atorList = leituraArquivoAtor.getArtistas();
        atrizList = leituraArquivoAtriz.getArtistas();

        //Quem foi o ator mais jovem a ganhar um Oscar?
        atorList.sort(Comparator.comparing(Artista::getAge));
        System.out.println("\nAtor mais jovem a ganhar um Oscar: " + leituraArquivoAtor.getArtistas().get(0).getName());

        //Quem foi a atriz que mais vezes foi premiada?
        atrizList = artistaList.stream().filter(artista -> artista.isFemale()).collect(Collectors.toList());
        Map<String, Long> tabelaHashAtrizMaisPremiada = artistaList.stream().collect(Collectors.groupingBy(artista -> artista.getName(), Collectors.counting()));
        System.out.println("\nArtista que mais vezes foi premiada: " + tabelaHashAtrizMaisPremiada.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey());

        //Qual atriz entre 20 e 30 anos que mais vezes foi vencedora?
        List<Artista> atrizBeetwen20and30 = artistaList.stream().filter(artista -> artista.isFemale() && artista.artistAgeIsBetween(20, 30)).collect(Collectors.toList());
        Map<String, Long> tabelaHashAtrizMaisPremiada20e30 = atrizBeetwen20and30.stream().collect(Collectors.groupingBy(artista -> artista.getName(), Collectors.counting()));
        Long maiorGanhoOscar = tabelaHashAtrizMaisPremiada20e30.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
        System.out.println("\nEntre 20 e 30 anos, com a mesma quantidade de Oscars, temos: ");
        tabelaHashAtrizMaisPremiada20e30.entrySet().stream().forEach(entry -> {
            if (entry.getValue() == maiorGanhoOscar) {
                System.out.println(entry.getKey());
            }
        });


        //Quais atores ou atrizes receberam mais de um Oscar? Elabore uma única estrutura contendo atores e atrizes.
        Map<String, Long> tabelaHashAtrizAtor = artistaList.stream().collect(Collectors.groupingBy(artista -> artista.getName(), Collectors.counting()));
        System.out.println("\nAtores e Atrizes que receberam mais de um Oscar: ");
        tabelaHashAtrizAtor.entrySet().stream().forEach(entry -> {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " -- " + entry.getValue() + " Oscars");
            }
        });

        //Quando informado o nome de um ator ou atriz, dê um resumo de quantos prêmios ele/ela recebeu e liste ano, idade e nome de cada filme pelo qual foi premiado(a).
        List<Artista> resumo = artistaList.stream().filter(artista -> artista.getName().equals("Katharine Hepburn")).collect(Collectors.toList());
        System.out.println("\n--- RESUMO DE PRÊMIOS ---\n");
        System.out.println("Quantidade de oscars: " + " " + resumo.size());
        for (Artista artista : resumo) {
            System.out.println("\nAno: " + artista.getYear());
            System.out.println("Idade: " + artista.getAge());
            System.out.println("Filme premiado: " + artista.getMovie() + "\n");
        }
    }
}
