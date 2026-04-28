package design.patterns.observer;

public class ConcreteObserver2<T> implements Observer<T> {

    private T data;
    private final Observable<T> observer;

    ConcreteObserver2(Observable<T> observer){
        this.observer = observer;
        observer.registerObserver(this);
        sync();
    }

    @Override
    public void sync() {
        data = observer.getData();
        System.out.println(this.getClass().getCanonicalName() + " : " + data);
    }

    @Override
    public void pushUpdate(T data) {
        observer.update(data);
    }
}
