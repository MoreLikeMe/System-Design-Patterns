package design.observer;

public class ConcreteObserver3<T> implements Observer<T> {

    private T data;
    private final Observable<T> observer;

    ConcreteObserver3(Observable<T> observer){
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
