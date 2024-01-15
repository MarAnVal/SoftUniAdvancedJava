package Jar;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> jar;

    public Jar() {
        this.jar =new ArrayDeque<>();
    }

    public void add(T element){
        this.jar.push(element);
    }

    public T remove() {
        return this.jar.pop();
    }
}
