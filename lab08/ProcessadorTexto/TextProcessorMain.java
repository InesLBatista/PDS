package lab08.src;

public class TextProcessorMain {
    public static void main(String[] args) {
        // Exemplo 1: Leitura Simples
        System.out.println("--- Exemplo 1: TextReader simples ---");
        TextStream reader1 = new TextReader("doc1.txt"); // [cite: 66]
        while (reader1.hasNext()) {
            System.out.println("Resultado: " + reader1.next());
        }

        System.out.println("\n--- Exemplo 2: TextReader com NormalizationFilter ---");
        // reader = new NormalizationFilter(new TextReader("someFileName")); [cite: 67]
        TextStream reader2 = new NormalizationFilter(new TextReader("doc2.txt"));
        while (reader2.hasNext()) {
            System.out.println("Resultado: " + reader2.next());
        }

        System.out.println("\n--- Exemplo 3: TermFilter + VowelFilter + CapitalizationFilter ---");
        // Um fluxo de filtros, onde o output de um é o input do próximo.
        // reader = new VowelFilter(new TermFilter(new TextReader("someFileName")); [cite: 68]
        // Se quisermos: CapitalizationFilter sobre TermFilter:
        TextStream reader3 = new CapitalizationFilter(new TermFilter(new TextReader("doc3.txt")));

        while (reader3.hasNext()) {
            String processedWord = reader3.next();
            if (processedWord != null) {
                System.out.println("Resultado Final: " + processedWord);
            }
        }
    }
}