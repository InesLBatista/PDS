package Praticas.lab09.ex1_a;
// Padrão Proxy para contrtolar o acesso baseado no perfil do utilizador

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

    public BankAccount getBankAccount() { 
        return new BankAccountProxy(bankAccount); 
    } 

    //Método de acesso direto para o próprio
    public BankAccount getBankAccountDirect() {
        return bankAccount;
    }
}
