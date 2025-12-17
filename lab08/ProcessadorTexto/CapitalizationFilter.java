package lab08.src;

public class CapitalizationFilter extends TextFilterDecorator {
    public CapitalizationFilter(TextStream wrappee) {
        super(wrappee);
    }

    @Override
    public String next() {
        String text = wrappee.next();
        if (text == null || text.isEmpty()) {
            return text;
        }
        
        // Coloca o primeiro e último caracter em maiúscula e o restante em minúscula
        if (text.length() == 1) {
            return text.toUpperCase();
        }
        
        char first = Character.toUpperCase(text.charAt(0));
        String middle = text.substring(1, text.length() - 1).toLowerCase();
        char last = Character.toUpperCase(text.charAt(text.length() - 1));

        String capitalized = "" + first + middle + last;

        System.out.println("CapitalizationFilter: " + capitalized);
        return capitalized; // Exemplo: "AlimentoS" [cite: 65]
    }
}
