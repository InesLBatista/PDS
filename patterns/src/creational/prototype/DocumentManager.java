package creational.prototype;
import java.util.*;

public class DocumentManager {
    private Map<String, Document> prototypes;
    
    public DocumentManager() {
        prototypes = new HashMap<>();
        initializePrototypes();
    }
    
    private void initializePrototypes() {
        // Cria protótipos padrão
        prototypes.put("text", new TextDocument());
        prototypes.put("spreadsheet", new SpreadsheetDocument());
        prototypes.put("presentation", new PresentationDocument());
    }
    
    // Método para criar documentos personalizados
    public void registerPrototype(String key, Document prototype) {
        prototypes.put(key, prototype);
    }
    
    // Cria um clone do protótipo
    public Document createDocument(String type) {
        Document prototype = prototypes.get(type);
        if (prototype != null) {
            return prototype.clone();
        }
        throw new IllegalArgumentException("Tipo de documento desconhecido: " + type);
    }
    
    // Método para demonstrar a criação e modificação de documentos
    public void demonstrateCloning() {
        System.out.println("=== Demonstração do Sistema de Clonagem de Documentos ===\n");
        
        // 1. Criação de documentos a partir de protótipos
        System.out.println("1. Criando documentos a partir de protótipos:");
        
        Document textDoc = createDocument("text");
        textDoc.setContent("Este é um documento de texto original.");
        textDoc.setMetadata("Autor: João, Data: 2024-01-15");
        
        Document spreadsheetDoc = createDocument("spreadsheet");
        spreadsheetDoc.setContent("Planilha de vendas Q1");
        spreadsheetDoc.setMetadata("Departamento: Finanças");
        
        Document presentationDoc = createDocument("presentation");
        presentationDoc.setContent("Apresentação anual");
        presentationDoc.setMetadata("Empresa: TechCorp");
        
        System.out.println("Texto original: " + textDoc);
        System.out.println("Planilha original: " + spreadsheetDoc);
        System.out.println("Apresentação original: " + presentationDoc);
        
        // 2. Clonagem de documentos existentes
        System.out.println("\n2. Clonando documentos:");
        
        Document textClone = textDoc.clone();
        textClone.setContent("Este é um clone modificado do documento de texto.");
        ((TextDocument) textClone).setAuthor("Maria");
        
        Document spreadsheetClone = spreadsheetDoc.clone();
        spreadsheetClone.setContent("Planilha de vendas Q2 (modificada)");
        ((SpreadsheetDocument) spreadsheetClone).addSheet("Sheet2");
        ((SpreadsheetDocument) spreadsheetClone).setRowCount(150);
        
        Document presentationClone = presentationDoc.clone();
        presentationClone.setContent("Apresentação trimestral (atualizada)");
        ((PresentationDocument) presentationClone).addSlide("Novos Produtos");
        ((PresentationDocument) presentationClone).setTheme("Corporate Blue");
        ((PresentationDocument) presentationClone).setHasAnimations(true);
        
        System.out.println("Clone de texto modificado: " + textClone);
        System.out.println("Clone de planilha modificado: " + spreadsheetClone);
        System.out.println("Clone de apresentação modificado: " + presentationClone);
        
        // 3. Verificação de independência
        System.out.println("\n3. Verificando independência dos clones:");
        System.out.println("Conteúdo original do texto: " + textDoc.getContent());
        System.out.println("Conteúdo do clone de texto: " + textClone.getContent());
        System.out.println("Os documentos são independentes? " + 
                          !textDoc.getContent().equals(textClone.getContent()));
        
        // 4. Demonstração de registro de novos protótipos
        System.out.println("\n4. Registrando e usando novo protótipo:");
        
        // Cria um protótipo personalizado
        TextDocument customTextPrototype = new TextDocument();
        customTextPrototype.setContent("Modelo de contrato padrão");
        customTextPrototype.setMetadata("Tipo: Legal, Versão: 2.0");
        customTextPrototype.setFormatting("Arial 12pt, Duplo espaçamento");
        customTextPrototype.setAuthor("Departamento Jurídico");
        
        // Registra o novo protótipo
        registerPrototype("contract", customTextPrototype);
        
        // Cria documentos a partir do novo protótipo
        Document contract1 = createDocument("contract");
        Document contract2 = createDocument("contract");
        
        contract1.setContent("Contrato de prestação de serviços - Cliente A");
        contract2.setContent("Contrato de confidencialidade - Empresa B");
        
        System.out.println("Contrato 1: " + contract1);
        System.out.println("Contrato 2: " + contract2);
    }


    
}
