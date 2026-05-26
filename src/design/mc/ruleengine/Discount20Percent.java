package design.mc.ruleengine;

import design.mc.ruleengine.entity.Action;
import design.mc.ruleengine.entity.Context;

public class Discount20Percent implements Action {
    @Override
    public void execute(Context context) {
        Cart cart = (Cart) context.getData("cart");
        cart.setPrice(cart.getPrice() - cart.getPrice()*20/100);
    }
}
