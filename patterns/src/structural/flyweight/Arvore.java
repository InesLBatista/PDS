package structural.flyweight;

class Arvore {
    // Dados extrínsecos - únicos para cada árvore
    private int x;
    private int y;
    private double altura;
    private double largura;
    
    // Referência ao flyweight (dados partilhados)
    private TipoArvore tipo;
    
    public Arvore(int x, int y, double altura, double largura, TipoArvore tipo) {
        this.x = x;
        this.y = y;
        this.altura = altura;
        this.largura = largura;
        this.tipo = tipo;
    }
    
    public void renderizar() {
        tipo.renderizar(x, y, altura, largura);
    }
    
    // Getters para demonstração
    public int getX() { return x; }
    public int getY() { return y; }
    public TipoArvore getTipo() { return tipo; }
}
