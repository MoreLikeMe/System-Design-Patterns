package design.lld.atm.withdrawal;

import design.lld.atm.entity.AtmMachine;

import java.util.Map;

public class TwoHundredHandler implements CashWithdrawalHandler{

    private final CashWithdrawalHandler nextHandler;

    public TwoHundredHandler(CashWithdrawalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public CashWithdrawalHandler getNextHandler() {
        return nextHandler;
    }

    @Override
    public Map<Integer, Integer> handleCash(AtmMachine atm, int amount, Map<Integer, Integer> dispenseDenoms) {
        int demonsNeeded = amount/200;
        int availableDenomCount = atm.getDenominations().get(200);
        if(demonsNeeded<=availableDenomCount){
            dispenseDenoms.put(200, demonsNeeded);
            amount = amount%200;
        } else {
            dispenseDenoms.put(200, availableDenomCount);
            amount -= (200*availableDenomCount);
        }
        getNextHandler().handleCash(atm, amount, dispenseDenoms);
        return dispenseDenoms;
    }
}
