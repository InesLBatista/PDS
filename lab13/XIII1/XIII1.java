package Praticas.lab13.XIII1;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class XIII1 {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fl = new PrintStream(new File("pds2022.txt"));
        test(System.out); // executa e escreve na consola
        fl.println(System.getProperty("user.dir"));
        fl.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        test(fl); // executa e escreve no ficheiro
        fl.close();
    }

    private static void test(PrintStream out) {
        question1(out);
        question2(out);
        question3(out);
    }

    private static void question1(PrintStream out) {
        out.println("\nQuestion 1) ----------------------------------\n");
        ToShare market = new ToShare();
        Product[] cars = {
            new Car("ZA11ZB", "Tesla, Grey, 2021", 100),
            new Van("AA22BB", "Chevrolet Chevy, 2020", 180),
            new Motorcycle("ZA33ZB", "Touring, 750, 2022", 85),
            new Car("BB44ZB", "Ford Mustang, Red, 2021", 150), 
        };
        for (Product item : cars) 
            market.add(item);

        out.println("--- All Products :");
        for (Product item : market.getProducts())
            out.println(item);        
    
        Client u1 = new Client("187", "Peter Pereira");
        Client u2 = new Client("957", "Anne Marques");
        Client u3 = new Client("826", "Mary Monteiro");
        market.share("ZA11ZB", u1);
        market.share(cars[2], u2);
        market.share("BB44ZB", u3);

        out.println("--- Shared Products :\n" + market.sharedProducts());
        market.giveBack(cars[0]);
        market.giveBack("BB44ZB");
        out.println("--- Shared Products :\n" + market.sharedProducts());
        
        market.remove("ZA11ZB");
        OldJeep oj = new OldJeep("JJ0011;Some old SUV;88.5"); // assume "code;description;points"
        market.add(new Jeep(oj));
        out.println("--- All Products :");
        for (Product item : market)
            out.println(item);    
    }

    private static void question2(PrintStream out) {
        out.println("\nQuestion 2 (output example) ----------------------------------\n");
        
        // Primeiro criar o ficheiro de produtos
        createTestFile("products.txt");
        
        ToShare market = new ToShare();
        
        // Primeiro adicionar produtos do ficheiro
        try {
            ProductsReader fileReader = new TextFileProductsReader("products.txt");
            List<Product> fileProducts = fileReader.getItems();
            for (Product p : fileProducts) {
                market.add(p);
            }
        } catch (Exception e) {
            // Se não conseguir ler do ficheiro, usar dados mock
            out.println("Erro ao ler ficheiro, usando dados mock: " + e.getMessage());
            ProductsReader mockReader = new MockProductsReader();
            List<Product> mockProducts = mockReader.getItems();
            for (Product p : mockProducts) {
                market.add(p);
            }
        }
        
        // Adicionar produtos da alínea 1
        market.add(new Van("AA22BB", "Chevrolet Chevy, 2020", 180));
        market.add(new Car("BB44ZB", "Ford Mustang, Red, 2021", 150));
        market.add(new Car("ZA11ZB", "Tesla, Grey, 2021", 100));
        market.add(new Motorcycle("ZA33ZB", "Touring, 750, 2022", 85));
        
        out.println("--- All Products :");
        out.println("Total : " + market.getProducts().size());
        
        // Ordenar produtos por tipo e código
        List<Product> sortedProducts = new ArrayList<>(market.getProducts());
        Collections.sort(sortedProducts, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                // Ordenar por tipo: Motorcycle, Van, Car, Jeep
                int typeOrder1 = getTypeOrder(p1);
                int typeOrder2 = getTypeOrder(p2);
                if (typeOrder1 != typeOrder2) {
                    return typeOrder1 - typeOrder2;
                }
                // Se mesmo tipo, ordenar por código
                return p1.getCode().compareTo(p2.getCode());
            }
            
            private int getTypeOrder(Product p) {
                if (p instanceof Motorcycle) return 1;
                if (p instanceof Van) return 2;
                if (p instanceof Car) return 3;
                if (p instanceof Jeep) return 4;
                return 5;
            }
        });
        
        for (Product item : sortedProducts) {
            out.println("\t" + item);
        }
    }

    private static void question3(PrintStream out) {
        out.println("\nQuestion 3) ----------------------------------\n");
        
        ToShareWithQueue shareIt = new ToShareWithQueue();
        
        // Adicionar produto
        Product p = new Car("UA0001", "Test Car", 100);
        shareIt.add(p);
        
        // Criar clientes
        Client u1 = new Client("1", "Peter Pereira");
        Client u2 = new Client("2", "Mary Monteiro");
        // Criar u3 mas não usar para eliminar o warning
        Client u3 = new Client("3", "Anne Marques");
        
        // Testar cenário do enunciado
        out.println("a) shareIt.share(\"UA0001\", u1);  // true");
        boolean result1 = shareIt.share("UA0001", u1);
        out.println("Result: " + result1);
        
        out.println("b) shareIt.share(\"UA0001\", u2);   // false (já está emprestada)");
        boolean result2 = shareIt.share("UA0001", u2);
        out.println("Result: " + result2);
        
        out.println("c) shareIt.giveBack(\"UA0001\");   // true (devolvida por u1, emprestado a u2)");
        boolean result3 = shareIt.giveBack("UA0001");
        out.println("Result: " + result3);
        
        out.println("d) shareIt.giveBack(\"UA0001\");   // true (devolvida por u2)");
        boolean result4 = shareIt.giveBack("UA0001");
        out.println("Result: " + result4);
        
        out.println("e) shareIt.giveBack(\"UA0001\");   // false");
        boolean result5 = shareIt.giveBack("UA0001");
        out.println("Result: " + result5);
        
        // Agora usar u3 para evitar o warning
        out.println("\n--- Teste adicional com u3 ---");
        shareIt.share("UA0001", u1);  // u1 aluga
        shareIt.share("UA0001", u2);  // u2 na fila
        shareIt.share("UA0001", u3);  // u3 na fila (agora usado)
        
        shareIt.giveBack("UA0001");  // vai para u2
        shareIt.giveBack("UA0001");  // vai para u3
        shareIt.giveBack("UA0001");  // fica disponível
    }
    
    // Método para criar ficheiro de teste
    private static void createTestFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println("Motorcycle\t900009\tBMW R1150R Boxer Naked Roadster Cinza ABS\t195");
            writer.println("Motorcycle\t900010\tHarley-Davidson Pan America 1250\t205");
            writer.println("Van\t970005\tJeep Grand Cherokee\t150");
            writer.println("Van\t970006\tAlfa Romeo AR6\t130");
            writer.println("Van\t980001\tGMC Safari\t130");
            writer.println("Van\t980002\tLancia Voyager\t120");
            writer.println("Car\t990000\tFord Maverick\t120");
            writer.println("Motorcycle\t990001\tDucati DesertX\t185");
            writer.println("Car\t990002\tMAZDA MX-5 Miata\t100");
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao criar ficheiro: " + e.getMessage());
        }
    }
}