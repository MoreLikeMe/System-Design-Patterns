package design.lld.splitwise;

import design.lld.splitwise.entity.Group;
import design.lld.splitwise.entity.SplitType;
import design.lld.splitwise.entity.User;
import design.lld.splitwise.service.ExpenseService;
import design.lld.splitwise.service.GroupService;
import design.lld.splitwise.service.LedgerService;
import design.lld.splitwise.service.UserService;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User abc = userService.createUser("#1234", "ABC");
        User pqr = userService.createUser("#2345", "PQR");
        User xyz = userService.createUser("#3456", "XYZ");

        GroupService groupService = new GroupService();
        Group dailyExpense = groupService.createGroup("Daily Expense 2026");
        groupService.addMemberToGroup(dailyExpense, abc);
        groupService.addMemberToGroup(dailyExpense, pqr);
        groupService.addMemberToGroup(dailyExpense, xyz);

        LedgerService ledgerService = new LedgerService();
        ExpenseService es = new ExpenseService(groupService, ledgerService);

        es.addExpense(dailyExpense.getGroupId(), abc, 300.0, SplitType.EQUAL, null);
        es.addExpense(dailyExpense.getGroupId(), xyz, 600.0, SplitType.EQUAL, null);
        ledgerService.showLedger(dailyExpense);

        Map<User, Double> unEqualSplitMap = Map.of(abc, 700.0, pqr, 200.0, xyz, 100.0);
        es.addExpense(dailyExpense.getGroupId(), pqr, 1000.0, SplitType.UNEQUAL, unEqualSplitMap);
        ledgerService.showLedger(dailyExpense);

        Map<User, Double> percentageSplitMap = Map.of(abc, 30.0, pqr, 30.0, xyz, 40.0);
        es.addExpense(dailyExpense.getGroupId(), pqr, 1000.0, SplitType.PERCENTAGE, percentageSplitMap);
        ledgerService.showLedger(dailyExpense);
    }
}