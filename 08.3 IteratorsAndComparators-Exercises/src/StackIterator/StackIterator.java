package StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StackIterator implements Iterable {
    private List<Integer> elements;

    public StackIterator(String... elements) {
        this.elements = new ArrayList<>();
        for (String current : elements) {
            this.elements.add(0, Integer.parseInt(current));
        }
    }

    public List<Integer> getElements() {
        return elements;
    }

    public void push(String... element) {
        for (String current : element) {
            this.elements.add(0, Integer.parseInt(current));
        }
    }

    public int pop() {
        if (elements.size() > 0) {
            int element = this.elements.get(0);
            this.elements.remove(0);
            return element;
        } else throw new IllegalStateException("No elements");
    }

    @Override
    public Iterator iterator() {
        return new CustomStackIterator();
    }

    private class CustomStackIterator implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return elements.size() > 0;
        }

        @Override
        public Integer next() {
            if(hasNext()){
                int current = elements.get(0);
                elements.remove(0);
                return current;
            } else throw new IllegalStateException("No elements");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        this.elements.forEach(e -> {
            result.append(e);
            result.append(System.lineSeparator());
        });
        return result.toString();
    }
}
