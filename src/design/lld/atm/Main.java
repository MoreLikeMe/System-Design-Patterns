package design.lld.atm;

import design.lld.atm.entity.*;

public class Main {
    public static void main(String[] args) {
        AtmMachine atm = new AtmMachine(2, 3, 4);
        System.out.println(atm.getBalance());
        System.out.println(atm.getDenominations());

        User user1 = createUser();
        Card card = user1.getCard();

        System.out.println("****************************************");
        atm.inserCard(card);
        atm.authenticatePin(card, "1234");
        atm.selectOperation(card, Operation.CHECK_BALANCE);
        atm.checkBalance(card);
        atm.exit(card);

        System.out.println("****************************************");
        atm.inserCard(card);
        atm.authenticatePin(card, "1234");
        atm.selectOperation(card, Operation.CASH_WITHDRAWAL);
        atm.withdrawCash(card, 1300);


        System.out.println("****************************************");
        System.out.println(atm.getBalance());
        System.out.println(atm.getDenominations());

        System.out.println("****************************************");
        atm.inserCard(card);
        atm.authenticatePin(card, "1234");
        atm.selectOperation(card, Operation.CASH_WITHDRAWAL);
        atm.withdrawCash(card, 600);

        System.out.println("****************************************");
        System.out.println(atm.getBalance());
        System.out.println(atm.getDenominations());
    }

    private static User createUser(){
        return new User("User1", createCard());
    }

    private static Card createCard(){
        return new Card("12345678", "456","12/29", createBankAccount());
    }

    private static BankAccount createBankAccount(){
        return new BankAccount("563546235423", 3000.0);
    }
}
