package lab08.src;

public class TermFilter extends TextFilterDecorator {
    private String[] words = new String[0];
    private int wordIndex = 0;

    public TermFilter(TextStream wrappee) {
        super(wrappee);
    }

    @Override
    public boolean hasNext() {
        // Continua se houver palavras no buffer OU se o wrappee tiver mais texto.
        return wordIndex < words.length || wrappee.hasNext();
    }

    @Override
    public String next() {
        // Se todas as palavras do buffer atual foram usadas, obtém o próximo parágrafo do wrappee
        if (wordIndex >= words.length) {
            String paragraph = wrappee.next();
            if (paragraph != null) {
                // Simplificação: divide por espaço e reseta o índice
                words = paragraph.split("\\s+");
                wordIndex = 0;
            } else {
                return null;
            }
        }
        
        // Devolve a próxima palavra do buffer
        if (wordIndex < words.length) {
            String word = words[wordIndex];
            System.out.println("TermFilter: Devolvendo palavra - " + word);
            wordIndex++;
            return word;
        }
        return null;
    }
}
