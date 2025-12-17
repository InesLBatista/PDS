package lab08.src;

public class TextReader implements TextStream {
    private String[] paragraphs;
    private int currentIndex = 0;

    public TextReader(String fileName) {
        // Implementação simplificada:
        System.out.println("TextReader: A ler ficheiro " + fileName);
        this.paragraphs = new String[]{
            "Alimentos potencialmente contaminados com químicos, aditivos e resíduos de pesticidas vão estar",
            "disponíveis numa base de dados."
        };
    }

    @Override
    public boolean hasNext() {
        return currentIndex < paragraphs.length;
    }

    @Override
    public String next() {
        if (hasNext()) {
            return paragraphs[currentIndex++];
        }
        return null;
    }
}