package Praticas.lab10.ex1;

import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Teste da Classe VECTORGENERIC: ");
        
        // 1. teste básico
        System.out.println("\n1. Teste Básico da Classe:");
        VectorGeneric<Integer> vector = new VectorGeneric<>();
        
        // Adicionar elementos
        for (int i = 1; i <= 8; i++) {
            vector.addElem(i * 10);
        }
        System.out.println("Elementos adicionados: 10, 20, 30, 40, 50, 60, 70, 80");
        System.out.println("Total de elementos: " + vector.totalElem());
        
        // 2. testes para iterador simples
        System.out.println("\n2. Testes para iterador simples: ");
        System.out.print("Iteração com Iterator: ");
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // 3. Teste do for-loop (Iterable)
        System.out.println("\n3. Teste do Enhanced FOR-LOOP:");
        System.out.print("Iteração com for-each: ");
        for (Integer num : vector) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // 4. Teste do listiterator no ínicio
        System.out.println("\n4. Teste do listiterator no ínicio:");
        ListIterator<Integer> listIterator = vector.listIterator();
        System.out.print("Navegação para a frente: ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        
        System.out.print("Navegação para trás: ");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
        
        // 5. Teste do listiterator com um índice específico
        System.out.println("\n5. Teste do listiterator com índice 3:");
        ListIterator<Integer> listIterFromIndex = vector.listIterator(3);
        System.out.print("A partir do índice 3: ");
        while (listIterFromIndex.hasNext()) {
            int nextIndex = listIterFromIndex.nextIndex();
            int value = listIterFromIndex.next();
            System.out.print("[" + nextIndex + "]=" + value + " ");
        }
        System.out.println();
        
        // 6. operações de modificação
        System.out.println("\n6. Teste de operadores de modificação:");
        
        // Teste do set()
        ListIterator<Integer> modIter1 = vector.listIterator();
        modIter1.next(); // Avançar para 10
        modIter1.set(15); // Alterar 10 para 15
        
        // Teste do add()
        ListIterator<Integer> modIter2 = vector.listIterator(2);
        modIter2.add(25); // Adicionar 25 na posição 2
        
        System.out.print("Vector após set(15) e add(25): ");
        for (Integer num : vector) {
            System.out.print(num + " ");
        }
        System.out.println("\nTotal de elementos: " + vector.totalElem());
        
        // 7. teste do remove
        System.out.println("\n7. Teste de remove:");
        Iterator<Integer> removeIter = vector.iterator();
        while (removeIter.hasNext()) {
            int value = removeIter.next();
            if (value == 40) {
                removeIter.remove();
                System.out.println("Removido elemento: 40");
            }
        }
        
        System.out.print("Vector após remoção do 40: ");
        for (Integer num : vector) {
            System.out.print(num + " ");
        }
        System.out.println("\nTotal de elementos: " + vector.totalElem());
        

        // 8. múltiplos iteradores simultâneos
        System.out.println("\n8. Teste de múltiplos iteradores simultâneos:");
        
        VectorGeneric<String> stringVector = new VectorGeneric<>();
        stringVector.addElem("A");
        stringVector.addElem("B");
        stringVector.addElem("C");
        stringVector.addElem("D");
        stringVector.addElem("E");
        
        Iterator<String> iter1 = stringVector.iterator();
        Iterator<String> iter2 = stringVector.iterator();
        ListIterator<String> listIter1 = stringVector.listIterator(2);
        
        System.out.println("Iterador 1: " + iter1.next()); // A
        System.out.println("Iterador 2: " + iter2.next()); // A
        System.out.println("ListIterator (índice 2): " + listIter1.next()); // C
        
        System.out.println("Iterador 1: " + iter1.next()); // B
        System.out.println("Iterador 2: " + iter2.next()); // B
        System.out.println("ListIterator: " + listIter1.previous()); // Volta para C
        
        // 9. TESTE DE NAVEGAÇÃO bideracional completa
        System.out.println("\n9. Teste de navegação bideracional:");
        ListIterator<Integer> biDirIter = vector.listIterator(2);
        
        System.out.println("Posição inicial - nextIndex: " + biDirIter.nextIndex());
        System.out.println("Próximo elemento: " + biDirIter.next()); // 25
        System.out.println("Próximo elemento: " + biDirIter.next()); // 30
        System.out.println("Elemento anterior: " + biDirIter.previous()); // 30
        System.out.println("Elemento anterior: " + biDirIter.previous()); // 25
        System.out.println("Próximo índice: " + biDirIter.nextIndex());
        System.out.println("Índice anterior: " + biDirIter.previousIndex());
        
        // 10. Teste de adição
        System.out.println("\n10. Teste de adição:");
        ListIterator<Integer> addIter = vector.listIterator();
        System.out.print("Vector original: ");
        for (Integer num : vector) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        addIter.next(); // 15
        addIter.next(); // 20
        addIter.add(22); // Adiciona 22 entre 20 e 25
        addIter.add(24); // Adiciona 24 entre 22 e 25
        
        System.out.print("Vector após adições: ");
        for (Integer num : vector) {
            System.out.print(num + " ");
        }
        System.out.println("\nTotal de elementos: " + vector.totalElem());
        
        // 11. Teste de execeções
        System.out.println("\n11. Teste de exceções:");
        
        try {
            Iterator<Integer> badIter = vector.iterator();
            badIter.remove(); // Deve lançar IllegalStateException
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException capturada: remove() sem next()");
        }
        
        try {
            vector.listIterator(100); // Índice inválido
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException capturada: índice 100 inválido");
        }
        
        try {
            ListIterator<Integer> badListIter = vector.listIterator();
            badListIter.set(100); // Deve lançar IllegalStateException
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException capturada: set() sem next()/previous()");
        }
        
        try {
            vector.getElem(50); // Índice inválido
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException capturada: getElem(50) inválido");
        }
        
        // 12. Teste com diferentes tipos
        System.out.println("\n12. Teste com strings:");
        VectorGeneric<String> stringVec = new VectorGeneric<>();
        stringVec.addElem("Hello");
        stringVec.addElem("World");
        stringVec.addElem("Java");
        
        System.out.print("Strings: ");
        for (String str : stringVec) {
            System.out.print(str + " ");
        }
        System.out.println();
        
        // 13. DEMONSTRAÇÃO DE removeElem
        System.out.println("\n13. Teste de removeElem:");
        System.out.print("Antes de remover '30': ");
        for (Integer num : vector) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        vector.removeElem(30);
        
        System.out.print("Depois de remover '30': ");
        for (Integer num : vector) {
            System.out.print(num + " ");
        }
        System.out.println("\nTotal de elementos: " + vector.totalElem());
    }
}