package creational.prototype;

public class Main {
    public static void main(String[] args) {
        DocumentManager manager = new DocumentManager();
        
        // Demonstração do sistema
        manager.demonstrateCloning();
        
        // Exemplo de uso programático
        System.out.println("\n=== Exemplo de Uso Programático ===");
        
        // Cria um documento a partir do protótipo
        Document newTextDoc = manager.createDocument("text");
        newTextDoc.setContent("Novo documento criado dinamicamente");
        System.out.println("Novo documento criado: " + newTextDoc);
        
        // Clona um documento existente
        Document clonedDoc = newTextDoc.clone();
        clonedDoc.setContent("Este é um clone do documento anterior");
        System.out.println("Documento clonado: " + clonedDoc);
        
        // Verifica se são objetos diferentes
        System.out.println("São o mesmo objeto? " + (newTextDoc == clonedDoc));
        System.out.println("Conteúdo igual? " + newTextDoc.getContent().equals(clonedDoc.getContent()));
    }
}
