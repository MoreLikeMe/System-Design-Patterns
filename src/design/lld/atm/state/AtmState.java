package design.lld.atm.state;

import design.lld.atm.entity.AtmMachine;
import design.lld.atm.entity.Card;
import design.lld.atm.entity.Operation;

public abstract class AtmState {
    public void insertCard(Card card, AtmMachine atm){
        throw new UnsupportedOperationException("Operation not allowed in current state");
    }

    public boolean authenticatePin(Card card, String pin, AtmMachine atm){
        throw new UnsupportedOperationException("Operation not allowed in current state");
    }

    public void selectOperation(Card card, Operation operation, AtmMachine atm){
        throw new UnsupportedOperationException("Operation not allowed in current state");
    }

    public double checkBalance(Card card, AtmMachine atm){
        throw new UnsupportedOperationException("Operation not allowed in current state");
    }

    public boolean pinChange(Card card, String newPin, AtmMachine atm){
        throw new UnsupportedOperationException("Operation not allowed in current state");
    }

    public void withdrawCash(Card card, int amount, AtmMachine atm){
        throw new UnsupportedOperationException("Operation not allowed in current state");
    }

    public void exit(Card card, AtmMachine atm){
        throw new UnsupportedOperationException("Operation not allowed in current state");
    }

    final void returnCard(Card card, AtmMachine atm){
        System.out.println("Returning the card back... Please collect your card");
    }
}
