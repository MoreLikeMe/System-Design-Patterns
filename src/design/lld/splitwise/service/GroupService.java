package design.lld.splitwise.service;

import design.lld.splitwise.entity.Expense;
import design.lld.splitwise.entity.Group;
import design.lld.splitwise.entity.User;

import java.util.HashMap;
import java.util.Map;

public class GroupService {
    private Map<String, Group> groups;

    public GroupService() {
        this.groups = new HashMap<>();
    }

    public Group createGroup(String groupName){
        Group group = new Group(groupName);
        groups.put(group.getGroupId(), group);
        return group;
    }

    public void addMemberToGroup(Group group, User user){
        group.addMember(user);
    }

    public void addExpenseToGroup(Group group, Expense expense){
        group.addExpense(expense);
    }

    public Group getGroupByGroupId(String groupId){
        return groups.get(groupId);
    }
}
