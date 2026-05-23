package design.lld.atm.state;

import design.lld.atm.entity.AtmMachine;
import design.lld.atm.entity.Card;
import design.lld.atm.withdrawal.CashWithdrawalHandler;
import design.lld.atm.withdrawal.FiveHundredHandler;
import design.lld.atm.withdrawal.OneHundredHandler;
import design.lld.atm.withdrawal.TwoHundredHandler;

import java.util.HashMap;
import java.util.Map;

public class CashWithdrawalState extends AtmState {

    CashWithdrawalHandler handler;

    public CashWithdrawalState() {
        this.handler = new FiveHundredHandler(new TwoHundredHandler(new OneHundredHandler(null)));
    }

    @Override
    public void withdrawCash(Card card, int amount, AtmMachine atm) {
        if(card.checkBalance()<amount){
            throw new UnsupportedOperationException("Insufficient balance in Account...");
        }
        if(atm.getBalance()<amount){
            throw new UnsupportedOperationException("Insufficient balance in ATM...");
        }
        System.out.println("Withdrawing cash...");
        Map<Integer, Integer> denomsToBeDispensed = handler.handleCash(atm, amount, new HashMap<Integer, Integer>());
        Map<Integer, Integer> availableDenoms = atm.getDenominations();

        /**
         * TODO:
         * Whether or not the denomations is able to serve the exact amount
         * that validation is not here yet
         */
        for(Map.Entry<Integer, Integer> entry: denomsToBeDispensed.entrySet()){
            availableDenoms.put(entry.getKey(), availableDenoms.get(entry.getKey())-entry.getValue());
        }
        card.deductAmount(amount);
        atm.deductAmount(amount);
        System.out.println("Withdraw Done...");
        exit(card, atm);
    }

    @Override
    public void exit(Card card, AtmMachine atm) {
        returnCard(card, atm);
        atm.updateState(new IdleState());
    }
}
