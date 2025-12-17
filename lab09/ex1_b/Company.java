package Praticas.lab09.ex1_b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();
    
    // MODIFICAÇÃO: Mudar a assinatura do método
    public void admitEmployee(Person person, double salary) {
        Employee e = new Employee(person, salary);
        emps.add(e);
    }
    
    public void paySalaries(int month) {
        for (Employee e : emps) {
            // MODIFICAÇÃO: Usar getSalaryAccount() em vez de getBankAccount()
            BankAccount salaryAccount = e.getSalaryAccount();
            salaryAccount.deposit(e.getSalary());
        }
    }
    
    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }
}
