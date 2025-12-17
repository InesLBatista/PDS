package lab08.src;

import java.text.Normalizer;

public class NormalizationFilter extends TextFilterDecorator {
    public NormalizationFilter(TextStream wrappee) {
        super(wrappee);
    }

    @Override
    public String next() {
        String text = wrappee.next();
        if (text == null) {
            return null;
        }
        
        // Remove acentuação
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD)
                                      .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        // Remove pontuação (simplificação)
        String cleaned = normalized.replaceAll("[^a-zA-Z0-9\\s]", "");

        System.out.println("NormalizationFilter: " + cleaned);
        return cleaned; // Exemplo: "quimicos" [cite: 58]
    }
}
