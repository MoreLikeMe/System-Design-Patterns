package design.lld.atm.withdrawal;

import design.lld.atm.entity.AtmMachine;

import java.util.Map;

public interface CashWithdrawalHandler {
    CashWithdrawalHandler getNextHandler();
    Map<Integer, Integer> handleCash(AtmMachine atm, int amount, Map<Integer, Integer> dispenseDenoms);
}
