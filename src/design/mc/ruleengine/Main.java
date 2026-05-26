package design.mc.ruleengine;

import design.mc.ruleengine.entity.Context;
import design.mc.ruleengine.entity.Rule;
import design.mc.ruleengine.entity.RuleEngine;

public class Main {
    public static void main(String[] args) {

        Rule rule1 = new Rule("Discount10%-value200to300", new GreaterThan200LesserThan300(), new Discount10Percent());
        Rule rule2 = new Rule("Discount20%-value300to400", new GreaterThan300LesserThan400(), new Discount20Percent());

        RuleEngine engine = new RuleEngine();
        engine.addRule(rule1);
        engine.addRule(rule2);

        Cart cart = new Cart(10, 350);
        Context context = new Context();
        context.addData("cart", cart);

        context = engine.start(context);

        System.out.println(((Cart) context.getData("cart")).getPrice());
    }
}
