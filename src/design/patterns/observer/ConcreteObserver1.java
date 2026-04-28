package design.patterns.observer;

public class ConcreteObserver1<T> implements Observer<T> {

    private T data;
    private final Observable<T> observer;

    ConcreteObserver1(Observable<T> observer){
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
