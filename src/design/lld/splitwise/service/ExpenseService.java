package design.lld.splitwise.service;

import design.lld.splitwise.entity.*;
import design.lld.splitwise.strategy.SplitStrategy;
import design.lld.splitwise.strategy.SplitStrategyFactory;

import java.util.List;
import java.util.Map;

public class ExpenseService {
    private SplitStrategy strategy;
    private GroupService groupService;
    private LedgerService ledgerService;

    public ExpenseService(GroupService groupService, LedgerService ledgerService) {
        this.groupService = groupService;
        this.ledgerService = ledgerService;
    }

    public Expense addExpense(String groupId, User paidBy, double total, SplitType splitType, Map<User, Double> userToValue){

        //Validate Splits
        Group group = groupService.getGroupByGroupId(groupId);
        if(!splitType.equals(SplitType.EQUAL)){
            for(User user: userToValue.keySet()){
                if(!group.doesUserExist(user.getMobNO())){
                    System.out.println("User No Part of group");
                    return null;
                }
            }
        }

        //Generate Splits
        strategy = SplitStrategyFactory.getStrategy(splitType);
        List<Split> splits = strategy.generateSplits(group, userToValue, total);

        //create expense
        Expense expense = new Expense(total, paidBy, splitType, splits);
        groupService.addExpenseToGroup(group, expense);

        //update ledge
        ledgerService.updateLedger(group, expense);

        return expense;
    }
}
