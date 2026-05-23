package design.lld.atm.state;

import design.lld.atm.entity.AtmMachine;
import design.lld.atm.entity.Card;
import design.lld.atm.entity.Operation;

public class SelectionState extends AtmState{

    public SelectionState(){
        System.out.println("Select your operation...");
    }

    @Override
    public void selectOperation(Card card, Operation operation, AtmMachine atm) {
        System.out.println("Operation Selected : " + operation);
        switch (operation){
            case CASH_WITHDRAWAL: atm.updateState(new CashWithdrawalState());
                                            break;
            case CHECK_BALANCE: atm.updateState(new CheckBalanceState());
                                          break;
            case PIN_CHANGE: atm.updateState(new PinChangeState());
                                       break;
            default: throw new UnsupportedOperationException("Operation not Allowed...");
        }
    }

    @Override
    public void exit(Card card, AtmMachine atm) {
        returnCard(card, atm);
        atm.updateState(new IdleState());
    }
}
