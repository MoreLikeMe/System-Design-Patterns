package design.lld.atm.entity;

import design.lld.atm.state.AtmState;
import design.lld.atm.state.IdleState;

import java.util.HashMap;
import java.util.Map;

public class AtmMachine {
    private int balance;
    private final Map<Integer, Integer> denominations;
    private AtmState machineState;

    public AtmMachine(int fiveHundred, int twoHundred, int oneHundred) {
        this.denominations = new HashMap<>();
        this.denominations.put(500, fiveHundred);
        this.denominations.put(200, twoHundred);
        this.denominations.put(100, oneHundred);

        this.balance = 500*fiveHundred+200*twoHundred+100*oneHundred;
        this.machineState = new IdleState();
    }

    public void inserCard(Card card){
        machineState.insertCard(card, this);
    }

    public boolean authenticatePin(Card card, String pin){
        return machineState.authenticatePin(card, pin, this);
    }

    public void selectOperation(Card card, Operation operation){
        machineState.selectOperation(card, operation, this);
    }

    public double checkBalance(Card card){
        return machineState.checkBalance(card, this);
    }

    public boolean pinChange(Card card, String newPin){
        return machineState.pinChange(card, newPin, this);
    }

    public void withdrawCash(Card card, int amount){
        machineState.withdrawCash(card, amount, this);
    }

    public void exit(Card card){
        machineState.exit(card, this);
    }

    public int getBalance() {
        return balance;
    }

    public Map<Integer, Integer> getDenominations() {
        return denominations;
    }

    public void updateState(AtmState newState){
        this.machineState = newState;
    }

    public void deductAmount(int amount){
        this.balance -= amount;
    }
}
