package design.patterns.observer;

public interface Observer<T> {
    void sync();
    void pushUpdate(T data);
}
