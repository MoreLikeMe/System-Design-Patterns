package design.lld.splitwise.strategy;

import design.lld.splitwise.entity.Group;
import design.lld.splitwise.entity.Split;
import design.lld.splitwise.entity.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    List<Split> generateSplits(Group group, Map<User, Double> userToValue, double amount);
}
