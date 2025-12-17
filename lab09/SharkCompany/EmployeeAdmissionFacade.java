package lab09.SharkCompany;

public class EmployeeAdmissionFacade {
    private Company company;
    private SocialSecurity socialSecurity;
    private Insurance insurance;
    private CardService cardService;
    private Parking parking;
    private double averageSalary; 

    public EmployeeAdmissionFacade(double averageSalary) {
        this.company = new Company();
        this.socialSecurity = new SocialSecurity();
        this.insurance = new Insurance();
        this.cardService = new CardService();
        this.parking = new Parking();
        this.averageSalary = averageSalary;
        
        System.out.println("\n*** Facade de Admissão Inicializada (Média Salarial: " + averageSalary + " EUROS) ***");
    }

    public boolean admitNewEmployee(Person person) {
        System.out.println(" INICIANDO ADMISSÃO do funcionário: " + person.getName());

        this.company.admitEmployee(person); 

        this.socialSecurity.regist(person);

        this.insurance.regist(person);

        this.cardService.createCard(person);

        if (person.getSalary() > this.averageSalary) {
            this.parking.allow(person);
        } else {
            this.parking.deny(person);
        }
        
        System.out.println(" Admissão de " + person.getName() + " CONCLUÍDA pela Facade.");

        return true; 
    }
}