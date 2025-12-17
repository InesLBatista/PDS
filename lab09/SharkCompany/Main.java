package lab09.SharkCompany;

public class Main {
    public static void main(String[] args) {
        double companyAverageSalary = 1500.00; 
        EmployeeAdmissionFacade hrFacade = new EmployeeAdmissionFacade(companyAverageSalary);
        Person highSalaryEmployee = new Person("Joana Silva", 2200.00);
        hrFacade.admitNewEmployee(highSalaryEmployee);
        Person lowSalaryEmployee = new Person("Rui Santos", 1200.00);
        hrFacade.admitNewEmployee(lowSalaryEmployee);
    }
}