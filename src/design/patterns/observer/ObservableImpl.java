package design.patterns.observer;

import java.util.HashSet;
import java.util.Set;

public class ObservableImpl<T> implements Observable<T> {
    private T data;
    private final Set<Observer<T>> list;

    ObservableImpl(){
        this.list = new HashSet<>();
    }

    @Override
    public void registerObserver(Observer<T> observable) {
        list.add(observable);
    }

    @Override
    public void update(T data) {
        this.data = data;
        notifyObserver();
    }

    private void notifyObserver() {
        for(Observer<T> observable: list){
            observable.sync();
        }
    }

    @Override
    public T getData() {
        return data;
    }
}
