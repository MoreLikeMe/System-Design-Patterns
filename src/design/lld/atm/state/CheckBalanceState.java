package design.lld.atm.state;

import design.lld.atm.entity.AtmMachine;
import design.lld.atm.entity.Card;

public class CheckBalanceState extends AtmState {

    @Override
    public double checkBalance(Card card, AtmMachine atm) {
        System.out.println("Available Balance:" + card.checkBalance());
        return card.checkBalance();
    }

    @Override
    public void exit(Card card, AtmMachine atm) {
        returnCard(card, atm);
        atm.updateState(new IdleState());
    }
}
