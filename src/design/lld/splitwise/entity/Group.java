package design.lld.splitwise.entity;

import java.util.*;

public class Group {
    private String groupId;
    private String groupName;
    private Map<String, User> members;
    private List<Expense> expenses;

    public Group(String groupName) {
        this.groupId = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.members = new HashMap<>();
        this.expenses = new ArrayList<>();
    }

    public void addMember(User user){
        members.put(user.getMobNO(), user);
    }

    public boolean doesUserExist(String userMobNo){
        return members.containsKey(userMobNo);
    }

    public void addExpense(Expense expense){
        expenses.add(expense);
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getMembers(){
        return new ArrayList<>(members.values());
    }
}
