package design.patterns.decorator;

public class ChickenDecorator extends PizzaDecorator{

    public ChickenDecorator(Pizaa pizza){
        super(pizza);
    }

    @Override
    int getDecoratedPrice() {
        return 10;
    }

}
