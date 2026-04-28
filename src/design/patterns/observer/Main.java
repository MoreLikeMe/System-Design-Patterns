package design.patterns.observer;

public class Main {
    public static void main(String[] args) {
        Observable<String> observer = new ObservableImpl<>();
        Observer<String> o1 = new ConcreteObserver1<>(observer);
        Observer<String> o2 = new ConcreteObserver2<>(observer);
        Observer<String> o3 = new ConcreteObserver3<>(observer);

        o2.pushUpdate("Color Red");

        o3.pushUpdate("Animal Blue");
    }
}
