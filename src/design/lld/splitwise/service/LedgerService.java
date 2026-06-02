package design.lld.splitwise.service;

import design.lld.splitwise.entity.Expense;
import design.lld.splitwise.entity.Group;
import design.lld.splitwise.entity.Ledger;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LedgerService {

    private final Map<String, Ledger> groupToLedger;

    public LedgerService() {
        this.groupToLedger = new HashMap<>();
    }

    public void updateLedger(Group group, Expense expense){
        groupToLedger.putIfAbsent(group.getGroupId(), new Ledger());
        Ledger ledger = groupToLedger.get(group.getGroupId());

        Map<String, Double> adjustAmounts = expense.getSplits().stream().collect(
                Collectors.toMap(
                        split -> split.getUser().getMobNO(),
                        split -> split.getAmount()*(-1)
                )
        );

        //The person who paid, adjust its amount by substracting its own share
        adjustAmounts.put(expense.getPaidBy().getMobNO()
                , expense.getAmount() + adjustAmounts.get(expense.getPaidBy().getMobNO()));

        ledger.update(adjustAmounts);
    }

    public void showLedger(Group group){
        System.out.println("Group : " + group.getGroupName()
                + " --- " + groupToLedger.get(group.getGroupId()));
    }
}
