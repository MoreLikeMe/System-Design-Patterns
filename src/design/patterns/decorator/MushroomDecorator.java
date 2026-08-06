package design.patterns.decorator;

public class MushroomDecorator extends PizzaDecorator{
    private Pizaa pizza;

    public MushroomDecorator(Pizaa pizza){
        super(pizza);
    }

    @Override
    int getDecoratedPrice() {
        return 8;
    }

}
