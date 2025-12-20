package creational.prototype;

public abstract class AbstractDocument implements Document {
    protected String content;
    protected String metadata;
    protected String type;
    
    public AbstractDocument(String type) {
        this.type = type;
        this.content = "";
        this.metadata = "";
    }
    
    @Override
    public String getType() {
        return type;
    }
    
    @Override
    public String getContent() {
        return content;
    }
    
    @Override
    public void setContent(String content) {
        this.content = content;
    }
    
    @Override
    public String getMetadata() {
        return metadata;
    }
    
    @Override
    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
    
    // Método clone padrão que não lança CloneNotSupportedException
    @Override
    public Document clone() {
        try {
            // Chama o clone() da Object, que faz shallow copy
            AbstractDocument cloned = (AbstractDocument) super.clone();
            // Faz deep copy dos atributos mutáveis se necessário
            cloned.content = this.content; // String é imutável, não precisa deep copy
            cloned.metadata = this.metadata;
            cloned.type = this.type;
            return cloned;
        } catch (CloneNotSupportedException e) {
            // Nunca deve acontecer pois implementamos Cloneable
            throw new AssertionError(e);
        }
    }
}
