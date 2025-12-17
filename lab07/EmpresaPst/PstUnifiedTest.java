package Praticas.lab07.EmpresaPst;

import Praticas.lab07.EmpresaPst.Sweets.*;
import Praticas.lab07.EmpresaPst.Petiscos.*;
import java.util.Arrays;
import java.util.List;

public class PstUnifiedTest {
    public static void main(String[] args) {
        // Instancia os sistemas legados
        DataBase db = new DataBase();
        Registos reg = new Registos();

        // Cria adapters
        ICompany sweetsAdapter = new DatabaseAdapter(db);
        ICompany petiscosAdapter = new RegistosAdapter(reg);

        // Coleção unificada
        List<ICompany> companies = Arrays.asList(sweetsAdapter, petiscosAdapter);

        // Adicionar empregados
        sweetsAdapter.addEmployee(1001, "Alice", "", 1200);
        sweetsAdapter.addEmployee(1002, "Bob", "", 950);
        petiscosAdapter.addEmployee(201, "Ana", "Silva", 1000);
        petiscosAdapter.addEmployee(202, "Bruno", "Costa", 1100);

        // Remover um empregado
        sweetsAdapter.removeEmployee(1002); // remove Bob

        // Verificar existência
        System.out.println("Alice existe? " + sweetsAdapter.existsEmployee(1001));
        System.out.println("Bob existe? " + sweetsAdapter.existsEmployee(1002));

        // Imprimir todos os registos usando a coleção unificada
        System.out.println("\n=== Registos Unificados ===");
        
        for (ICompany company : companies) {
            company.printAllEmployees();
            System.out.println("---");
        }
        
        // Os prints individuais originais (podem ser removidos, mas mantidos para comparação)
        System.out.println("\n=== Registos Sweets (Individual) ===");
        sweetsAdapter.printAllEmployees();

        System.out.println("\n=== Registos Petiscos (Individual) ===");
        petiscosAdapter.printAllEmployees();
    }
}