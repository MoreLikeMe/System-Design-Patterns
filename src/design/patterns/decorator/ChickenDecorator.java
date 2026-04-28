package design.patterns.decorator;

public class ChickenDecorator extends PizzaDecorator{
    private Pizaa pizza;

    public ChickenDecorator(Pizaa pizza){
        this.pizza = pizza;
    }

    @Override
    public int price() {
        return pizza.price()+7;
    }
}
