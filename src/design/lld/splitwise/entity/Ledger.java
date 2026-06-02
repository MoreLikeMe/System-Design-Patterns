package design.lld.splitwise.entity;

import java.util.HashMap;
import java.util.Map;

public class Ledger {
    private final Map<String, Double> userBalanceSheets;

    public Ledger() {
        this.userBalanceSheets = new HashMap<>();
    }

    public void update(Map<String, Double> adjusteSheets){
        for(Map.Entry<String, Double> adjust: adjusteSheets.entrySet()){
            userBalanceSheets.putIfAbsent(adjust.getKey(), 0.0);
            userBalanceSheets.put(adjust.getKey(),
                    userBalanceSheets.get(adjust.getKey())+adjust.getValue());
        }
    }

    @Override
    public String toString() {
        return "Ledger{" +
                "userBalanceSheets=" + userBalanceSheets +
                '}';
    }
}
