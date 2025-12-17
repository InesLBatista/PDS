package Praticas.lab09.ex1_b;

class EmployeeBankAccountProxy implements BankAccount {
    private BankAccount realAccount;
    
    public EmployeeBankAccountProxy(BankAccount realAccount) {
        this.realAccount = realAccount;
    }
    
    @Override
    public void deposit(double amount) {
        // A empresa pode sempre depositar salários
        realAccount.deposit(amount);
    }
    
    @Override
    public boolean withdraw(double amount) {
        // A empresa NÃO pode levantar
        if (Company.user == User.COMPANY) {
            throw new SecurityException("Acesso negado.");
        }
        // Apenas o próprio funcionário pode levantar
        return realAccount.withdraw(amount);
    }
    
    @Override
    public double balance() {
        // A empresa NÃO pode consultar saldo
        if (Company.user == User.COMPANY) {
            throw new SecurityException("Acesso negado.");
        }
        // Apenas o próprio funcionário pode consultar
        return realAccount.balance();
    }
}