package Praticas.lab07.ex3;


public class Document {
    private String text;
    
    public Document(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        return text;
    }
}