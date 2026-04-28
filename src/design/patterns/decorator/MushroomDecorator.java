package design.patterns.decorator;

public class MushroomDecorator extends PizzaDecorator{
    private Pizaa pizza;

    public MushroomDecorator(Pizaa pizza){
        this.pizza = pizza;
    }

    @Override
    public int price() {
        return pizza.price()+5;
    }
}
