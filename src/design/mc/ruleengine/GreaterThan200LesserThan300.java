package design.mc.ruleengine;

import design.mc.ruleengine.entity.Condition;
import design.mc.ruleengine.entity.Context;

public class GreaterThan200LesserThan300 implements Condition {

    @Override
    public boolean evaluate(Context context) {
        Cart cart = (Cart) context.getData("cart");
        return cart.getPrice()>200 && cart.getPrice()<300;
    }
}
