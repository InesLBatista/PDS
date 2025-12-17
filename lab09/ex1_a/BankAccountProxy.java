package Praticas.lab09.ex1_a;

public class BankAccountProxy implements BankAccount {
    private BankAccount realAccount;

    public BankAccountProxy(BankAccount realAccount) {
        this.realAccount=realAccount;
    }

    @Override
    public void deposit(double amount) {
        realAccount.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        //WithDraw apenas é permitindo para o owner
        if(Company.user == User.OWNER) {
            return realAccount.withdraw(amount);
        } else {
            System.out.println("Acesso Negado.");
            return false;
        }
    }

    @Override
    public double balance() {
        //Balance apenas deve ser permitido para o onwer 
        if(Company.user == User.OWNER) {
            return realAccount.balance();
        } else {
            System.out.println("Acesso negado.");
            return -1;
        }
    }
}
