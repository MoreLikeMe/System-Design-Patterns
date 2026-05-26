package design.mc.ruleengine;

import design.mc.ruleengine.entity.Condition;
import design.mc.ruleengine.entity.Context;

public class GreaterThan300LesserThan400 implements Condition {

    @Override
    public boolean evaluate(Context context) {
        Cart cart = (Cart) context.getData("cart");
        return cart.getPrice()>300 && cart.getPrice()<400;
    }
}
