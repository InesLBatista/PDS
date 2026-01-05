package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

class FlorestaFactory {
    private static final Map<String, TipoArvore> cacheTipos = new HashMap<>();
    
    // Método para obter/criar tipos de árvores (garante que cada tipo é único)
    public static TipoArvore getTipoArvore(String nome, String cor, String textura) {
        String chave = nome + "_" + cor + "_" + textura;
        
        if (!cacheTipos.containsKey(chave)) {
            System.out.println("Criando NOVO tipo de árvore: " + nome);
            cacheTipos.put(chave, new TipoArvore(nome, cor, textura));
        } else {
            System.out.println("Reutilizando tipo de árvore existente: " + nome);
        }
        
        return cacheTipos.get(chave);
    }
    
    public static int getNumeroTiposCriados() {
        return cacheTipos.size();
    }
}