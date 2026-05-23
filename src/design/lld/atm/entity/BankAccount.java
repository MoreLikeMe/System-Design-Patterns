package design.lld.atm.entity;

public class BankAccount {
    private final String bankAccNo;
    private double balance;

    public BankAccount(String bankAccNo, double balance) {
        this.bankAccNo = bankAccNo;
        this.balance = balance;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public double getBalance() {
        return balance;
    }

    public void deductAmount(double amount){
        if(this.balance>=amount){
            this.balance -= amount;
            return;
        }
        throw new RuntimeException("Insufficient Balance");
    }
}
