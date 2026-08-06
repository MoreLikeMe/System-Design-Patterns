package design.patterns.observer;

public interface Observable<T> {
    void registerObserver(Observer<T> observer);
    void update(T data);
    T getData();
}
