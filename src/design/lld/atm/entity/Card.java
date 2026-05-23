package design.lld.atm.entity;

public class Card {
    private final String cardNo;
    private final String cvv;
    private final String expiry;
    private final BankAccount linkedBankAccount;
    private String pinNumber;

    public Card(String cardNo, String cvv, String expiry, BankAccount linkedBankAccount) {
        this.cardNo = cardNo;
        this.cvv = cvv;
        this.expiry = expiry;
        this.linkedBankAccount = linkedBankAccount;
        this.pinNumber = "1234";
    }

    public boolean checkPin(String enteredPin){
        return enteredPin.equals(pinNumber);
    }

    public void updatePin(String newPin){
        this.pinNumber = newPin;
    }

    public double checkBalance(){
        return linkedBankAccount.getBalance();
    }

    public void deductAmount(double amount){
        linkedBankAccount.deductAmount(amount);
    }

}
