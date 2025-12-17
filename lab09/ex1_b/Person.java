package Praticas.lab09.ex1_b;

class Person {
    private String name;
    private BankAccount bankAccount;

    public Person(String n) {
        name = n;
        bankAccount = new BankAccountImpl("PeDeMeia", 0);
    }
    
    public String getName() {
        return name;
    }
    
    //Mudar para package-private ou protected
    //Para que Employee possa aceder, mas classes externas não
    BankAccount getBankAccount() {
        return bankAccount;
    }
}