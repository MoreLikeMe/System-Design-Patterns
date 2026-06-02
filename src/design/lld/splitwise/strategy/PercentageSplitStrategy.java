package design.lld.splitwise.strategy;

import design.lld.splitwise.entity.Group;
import design.lld.splitwise.entity.Split;
import design.lld.splitwise.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PercentageSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> generateSplits(Group group, Map<User, Double> userToValue, double amount) {
        double percentageSum = userToValue.values().stream().mapToDouble(Double::doubleValue).sum();
        if(percentageSum != 100.0){
            System.out.println("Invalid Split Percentage input");
            return null;
        }

        List<Split> splits = new ArrayList<>();
        for(Map.Entry<User, Double> entry: userToValue.entrySet()){
            splits.add(new Split(entry.getKey(), amount*entry.getValue()/100));
        }
        return splits;
    }
}
