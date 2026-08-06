package design.patterns.decorator;

public abstract class PizzaDecorator implements Pizaa {

    private Pizaa pizza;

    protected PizzaDecorator(Pizaa pizza){
        this.pizza = pizza;
    }

    abstract int getDecoratedPrice();

    @Override
    public int price() {
        return pizza.price() + getDecoratedPrice();
    }
}
