import java.util.Arrays;
import java.util.List;

public class TestMovie {

    public static void main(String[] args) {

        Person nolan = new Person("Christopher Nolan");
        Place usa = new Place("Estados Unidos");

        System.out.println("--- Criando o objeto Movie 'Interstellar' ---");
        
        Movie interstellar = Movie.builder("Interstellar", 2014)
                                  .director(nolan)
                                  .writer(new Person("Jonathan Nolan"))
                                  .cast(Arrays.asList(new Person("Matthew McConaughey")))
                                  .locations(List.of(usa))
                                  .languages(List.of("Inglês"))
                                  .genres(Arrays.asList("Sci-Fi", "Drama", "Aventura"))
                                  .isIndependent(false)
                                  .build();

        System.out.println("\n--- Detalhes do Filme ---");
        System.out.println("Título: " + interstellar.getTitle());
        System.out.println("Ano: " + interstellar.getYear());
        System.out.println("Diretor: " + interstellar.getDirector().getName());
        System.out.println("Gêneros: " + interstellar.getGenres());
        System.out.println("É da Netflix?: " + interstellar.isNetflix());

        System.out.println("\n--- Exemplo Mínimo ---");
        Movie minimo = Movie.builder("Filme Simples", 2025).build();
        System.out.println("Título: " + minimo.getTitle());
        System.out.println("Elenco (tamanho - padrão 0): " + minimo.getCast().size());
    }
}