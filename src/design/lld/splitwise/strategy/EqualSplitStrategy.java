package design.lld.splitwise.strategy;

import design.lld.splitwise.entity.Group;
import design.lld.splitwise.entity.Split;
import design.lld.splitwise.entity.User;

import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> generateSplits(Group group, Map<User, Double> userToValue, double amount) {
        int groupMemberCount = group.getMembers().size();
        double splitAmount = amount/groupMemberCount;
        return group.getMembers().stream().map(user -> new Split(user, splitAmount)).toList();
    }
}
