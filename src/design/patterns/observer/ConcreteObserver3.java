package design.patterns.observer;

public class ConcreteObserver3<T> implements Observer<T> {

    private T data;
    private final Observable<T> observable;

    ConcreteObserver3(Observable<T> observable){
        this.observable = observable;
        observable.registerObserver(this);
        sync();
    }

    @Override
    public void sync() {
        data = observable.getData();
        System.out.println(this.getClass().getCanonicalName() + " : " + data);
    }

    @Override
    public void pushUpdate(T data) {
        observable.update(data);
    }
}
