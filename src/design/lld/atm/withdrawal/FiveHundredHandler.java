package design.lld.atm.withdrawal;

import design.lld.atm.entity.AtmMachine;
import java.util.Map;

public class FiveHundredHandler implements CashWithdrawalHandler{

    private final CashWithdrawalHandler nextHandler;

    public FiveHundredHandler(CashWithdrawalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public CashWithdrawalHandler getNextHandler() {
        return nextHandler;
    }

    @Override
    public Map<Integer, Integer> handleCash(AtmMachine atm, int amount, Map<Integer, Integer> dispenseDenoms) {
        int demonsNeeded = amount/500;
        int availableDenomCount = atm.getDenominations().get(500);
        if(demonsNeeded<=availableDenomCount){
            dispenseDenoms.put(500, demonsNeeded);
            amount = amount%500;
        } else {
            dispenseDenoms.put(500, availableDenomCount);
            amount -= (500*availableDenomCount);
        }
        getNextHandler().handleCash(atm, amount, dispenseDenoms);
        return dispenseDenoms;
    }
}
