package design.lld.splitwise.strategy;

import design.lld.splitwise.entity.SplitType;

public class SplitStrategyFactory {

    public static SplitStrategy getStrategy(SplitType splitType){

        SplitStrategy splitStrategy = null;
        switch (splitType){
            case EQUAL ->  splitStrategy = new EqualSplitStrategy();
            case UNEQUAL ->  splitStrategy = new UnequalSplitStrategy();
            case PERCENTAGE -> splitStrategy = new PercentageSplitStrategy();
        }
        return splitStrategy;
    }
}
