package letscode.avaliacao02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class LeituraArquivo {

    private final List<Artista> artistas;

    public List<Artista> getArtistas() {
        return artistas;
    }

    public LeituraArquivo(String fileartista, Artista.Sex sex) {
        this.artistas = lerArquivo(fileartista, sex);
    }

    private List<Artista> lerArquivo(String fileartista, Artista.Sex sex) {
        try (Stream<String> fileLines = Files.lines(Paths.get(fileartista))) {
            return fileLines
                    .skip(1)
                    .map(line -> Artista.of(line, sex))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
