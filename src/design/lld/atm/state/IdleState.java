package design.lld.atm.state;

import design.lld.atm.entity.AtmMachine;
import design.lld.atm.entity.Card;

public class IdleState extends AtmState{

    @Override
    public void insertCard(Card card, AtmMachine atm) {
        System.out.println("Card inserted");
        atm.updateState(new HasCardState());
    }
}
