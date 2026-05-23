package design.lld.atm.withdrawal;

import design.lld.atm.entity.AtmMachine;

import java.util.Map;

public class OneHundredHandler implements CashWithdrawalHandler{

    private final CashWithdrawalHandler nextHandler;

    public OneHundredHandler(CashWithdrawalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public CashWithdrawalHandler getNextHandler() {
        return nextHandler;
    }

    @Override
    public Map<Integer, Integer> handleCash(AtmMachine atm, int amount, Map<Integer, Integer> dispenseDenoms) {
        int demonsNeeded = amount/100;
        int availableDenomCount = atm.getDenominations().get(100);
        if(demonsNeeded<=availableDenomCount){
            dispenseDenoms.put(100, demonsNeeded);
            amount = amount%100;
        } else {
            dispenseDenoms.put(100, availableDenomCount);
            amount -= (100*availableDenomCount);
        }
        if(getNextHandler()!=null)
            getNextHandler().handleCash(atm, amount, dispenseDenoms);
        return dispenseDenoms;
    }
}
