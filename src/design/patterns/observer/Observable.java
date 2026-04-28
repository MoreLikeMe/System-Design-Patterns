package design.patterns.observer;

public interface Observable<T> {
    void registerObserver(Observer<T> observable);
    void update(T data);
    T getData();
}
