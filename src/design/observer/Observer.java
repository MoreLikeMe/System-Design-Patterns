package design.observer;

public interface Observer<T> {
    void sync();
    void pushUpdate(T data);
}
