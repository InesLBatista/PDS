package ex2;
public class NullDemo {
    public static void main(String[] args) {
        
        Employee emp = EmployeeFactory.getEmployee("Mac");
        
        Employee emp2 = EmployeeFactory.getEmployee("Janela");
        
        Employee emp3 = EmployeeFactory.getEmployee("Linux");
        
        Employee emp4 = EmployeeFactory.getEmployee("Mack");
        
        System.out.println("Emp 1: " + emp.getName());    
        System.out.println("Emp 2: " + emp2.getName());   
        System.out.println("Emp 3: " + emp3.getName());  
        System.out.println("Emp 4: " + emp4.getName());   

        System.out.println("\n--- Verificação de Nulidade ---");
        System.out.println("Emp 1 é nulo? " + emp.isNull());    
        System.out.println("Emp 2 é nulo? " + emp2.isNull());   
    }
}