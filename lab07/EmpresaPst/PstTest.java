package Praticas.lab07.EmpresaPst;

import Praticas.lab07.EmpresaPst.Sweets.*;
import Praticas.lab07.EmpresaPst.Petiscos.*;

public class PstTest {
    public static void main(String[] args) {
        // Teste Sweets
        System.out.println("=== Teste Sweets ===");
        DataBase db = new DataBase();
        db.addEmployee(new Employee("Alice", 1001, 1200.50));
        db.addEmployee(new Employee("Bob", 1002, 950.00));
        db.addEmployee(new Employee("Carla", 1003, 1350.75));

        for (Employee e : db.getAllEmployees()) {
            System.out.println(e);
        }

        db.deleteEmployee(1002);
        System.out.println("\nApós remover Bob:");
        for (Employee e : db.getAllEmployees()) {
            System.out.println(e);
        }

        // Teste Petiscos
        System.out.println("\n=== Teste Petiscos ===");
        Registos reg = new Registos();
        reg.insere(new Empregado("Ana", "Silva", 201, 1000.00));
        reg.insere(new Empregado("Bruno", "Almeida", 202, 1100.50));
        reg.insere(new Empregado("Carla", "Rocha", 203, 950.75));

        for (Empregado e : reg.listaDeEmpregados()) {
            System.out.println(e);
        }

        reg.remove(202);
        System.out.println("\nApós remover Bruno:");
        for (Empregado e : reg.listaDeEmpregados()) {
            System.out.println(e);
        }
    }
}
