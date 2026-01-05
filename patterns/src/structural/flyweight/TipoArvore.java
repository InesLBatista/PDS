package structural.flyweight;

public class TipoArvore {
    // Dados intrínsecos - partilhados entre todas as árvores do mesmo tipo
    private final String nome;
    private final String cor;
    private final String textura;
    
    public TipoArvore(String nome, String cor, String textura) {
        this.nome = nome;
        this.cor = cor;
        this.textura = textura;
    }
    
    public void renderizar(int x, int y, double altura, double largura) {
        System.out.printf("Renderizando %s na posição (%d, %d):\n", nome, x, y);
        System.out.printf("  Cor: %s, Textura: %s\n", cor, textura);
        System.out.printf("  Altura: %.1fm, Largura: %.1fm\n", altura, largura);
        System.out.println("  ---");
    }
    
    // Getters para demonstração
    public String getNome() { return nome; }
    public String getCor() { return cor; }
    public String getTextura() { return textura; }
}
