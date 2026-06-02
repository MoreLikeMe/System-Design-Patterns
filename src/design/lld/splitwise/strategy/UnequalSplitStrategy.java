package design.lld.splitwise.strategy;

import design.lld.splitwise.entity.Group;
import design.lld.splitwise.entity.Split;
import design.lld.splitwise.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnequalSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> generateSplits(Group group, Map<User, Double> userToValue, double amount) {
        double sum = userToValue.values().stream().mapToDouble(Double::doubleValue).sum();
        if(sum != amount){
            System.out.println("Invalid Split Share input");
            return null;
        }

        List<Split> splits = new ArrayList<>();
        for(Map.Entry<User, Double> entry: userToValue.entrySet()){
            splits.add(new Split(entry.getKey(), entry.getValue()));
        }
        return splits;
    }
}
