package Praticas.lab09.ex1_b;

import java.util.*;

public class SharkCompany2 {
    public static void main(String[] args) {
        Person[] pessoas = {
            new Person("Maria Silva"),
            new Person("Manuel Pereira"), 
            new Person("Aurora Machado"),
            new Person("Augusto Lima")
        };
        
        Company shark = new Company();
        
        System.out.println("=== CONTRATAÇÃO DE FUNCIONÁRIOS ===");
        Company.user = User.COMPANY;
        shark.admitEmployee(pessoas[0], 1000);
        shark.admitEmployee(pessoas[1], 900);
        shark.admitEmployee(pessoas[2], 1200);
        shark.admitEmployee(pessoas[3], 1100);
        
        List<Employee> funcionariosShark = shark.employees();
        
        System.out.println("\n=== SALÁRIOS DOS FUNCIONÁRIOS ===");
        for (Employee e : funcionariosShark) {
            System.out.println(e.getName() + ": " + e.getSalary() + "€");
        }
        
        System.out.println("\n=== PAGAMENTO DE SALÁRIOS (MODO EMPRESA) ===");
        shark.paySalaries(1);
        System.out.println("Salários pagos com sucesso!");
        
        System.out.println("\n=== TENTATIVAS DE ACESSO DA EMPRESA ===");
        try {
            // Tentativa de consultar saldo - deve falhar
            funcionariosShark.get(0).getSalaryAccount().balance();
            System.out.println("ERRO: A empresa conseguiu consultar o saldo!");
        } catch (SecurityException e) {
            System.out.println("✓ Restrição a funcionar: " + e.getMessage());
        }
        
        try {
            // Tentativa de levantar - deve falhar
            funcionariosShark.get(0).getSalaryAccount().withdraw(100);
            System.out.println("ERRO: A empresa conseguiu levantar dinheiro!");
        } catch (SecurityException e) {
            System.out.println("✓ Restrição a funcionar: " + e.getMessage());
        }
        
        System.out.println("\n=== ACESSO PESSOAL (MODO FUNCIONÁRIO) ===");
        Company.user = User.OWNER;
        
        for (Employee e : funcionariosShark) {
            BankAccount contaPessoal = e.getPersonalAccount();
            if (contaPessoal != null) {
                System.out.println(e.getName() + " - Saldo: " + contaPessoal.balance() + "€");
                boolean sucesso = contaPessoal.withdraw(200);
                System.out.println(e.getName() + " - Levantamento de 200€: " + (sucesso ? "SUCESSO" : "FALHA"));
                System.out.println(e.getName() + " - Saldo após levantamento: " + contaPessoal.balance() + "€");
                System.out.println("---");
            }
        }
        
        System.out.println("\n=== SEGUNDO PAGAMENTO DE SALÁRIOS ===");
        Company.user = User.COMPANY;
        shark.paySalaries(2);
        System.out.println("Segundo pagamento de salários realizado!");
        
        System.out.println("\n=== VERIFICAÇÃO FINAL DOS SALDOS ===");
        Company.user = User.OWNER;
        for (Employee e : funcionariosShark) {
            BankAccount contaPessoal = e.getPersonalAccount();
            if (contaPessoal != null) {
                System.out.println(e.getName() + " - Saldo final: " + contaPessoal.balance() + "€");
            }
        }
    }
}