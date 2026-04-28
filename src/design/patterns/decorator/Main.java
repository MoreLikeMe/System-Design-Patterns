package design.patterns.decorator;

public class Main {
    public static void main(String[] args) {
        Pizaa pizza1 = new MushroomDecorator(new ChickenDecorator(new Cheesecrust()));
        System.out.println(pizza1.price());

        Pizaa pizza2 = new MushroomDecorator(new ChickenDecorator(new Thincrust()));
        System.out.println(pizza2.price());
    }
}
