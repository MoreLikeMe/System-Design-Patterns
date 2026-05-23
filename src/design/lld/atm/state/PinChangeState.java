package design.lld.atm.state;

import design.lld.atm.entity.AtmMachine;
import design.lld.atm.entity.Card;

public class PinChangeState extends AtmState {

    @Override
    public boolean pinChange(Card card, String newPin, AtmMachine atm) {
        /**
         * validate pin before that
         */
        card.updatePin(newPin);
        System.out.println("Pin Changed successfully...");
        exit(card, atm);
        return true;
    }

    @Override
    public void exit(Card card, AtmMachine atm) {
        returnCard(card, atm);
        atm.updateState(new IdleState());
    }
}
