package Praticas.lab09.ex1_b;

class Employee {
    private Person person;
    private double salary;
    private BankAccount salaryAccount; // Conta proxy com restrições

    public Employee(Person person, double salary) {
        this.person = person;
        this.salary = salary;
        // Cria um proxy que restringe o acesso da empresa
        this.salaryAccount = new EmployeeBankAccountProxy(person.getBankAccount());
    }
    
    public String getName() {
        return person.getName();
    }
    
    public double getSalary() {
        return salary;
    }
    
    // Método para a empresa aceder à conta (apenas para depósitos)
    BankAccount getSalaryAccount() {
        return salaryAccount;
    }
    
    // Método para o funcionário aceder à conta completa
    public BankAccount getPersonalAccount() {
        if (Company.user == User.OWNER) {
            return person.getBankAccount();
        }
        return null; // ou lançar exceção
    }
}
