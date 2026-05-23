package design.lld.atm.state;

import design.lld.atm.entity.AtmMachine;
import design.lld.atm.entity.Card;

public class HasCardState extends AtmState{

    public HasCardState() {
        System.out.println("Enter Atm pin: ");
    }

    @Override
    public boolean authenticatePin(Card card, String pin, AtmMachine atm) {
        System.out.println("Checking Atm pin...");
        if(card.checkPin(pin)){
            atm.updateState(new SelectionState());
            return true;
        }
        System.out.println("Wrong pin entered...");
        exit(card, atm);
        return false;
    }

    @Override
    public void exit(Card card, AtmMachine atm) {
        returnCard(card, atm);
        atm.updateState(new IdleState());
    }
}
