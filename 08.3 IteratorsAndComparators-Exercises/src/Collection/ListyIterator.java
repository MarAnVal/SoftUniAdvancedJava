package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator<String> implements Iterable<String> {
    private List<String> elements;
    private int currentIndex;

    public ListyIterator() {
        this.elements = new ArrayList<>();
        this.currentIndex = 0;
    }

    public List<String> getElements() {
        return elements;
    }

    //· Move - should move an internal index position to the next index in the list,
    //the method should return true if it successfully moved and false if there is no next index.
    public boolean move() {
        if (hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }

    //· HasNext - should return true if there is a next index and false
    //if the index is already at the last element of the list.
    public boolean hasNext() {
        if (this.currentIndex < this.elements.size() - 1) {
            return true;
        }
        return false;
    }

    //· Print - should print the element at the current internal index,
    //calling Print on a collection without elements should throw an
    //appropriate exception with the message "Invalid Operation!".
    public void print() {
        if (this.elements.size() < 1) {
            throw new IllegalStateException("Invalid Operation!");
        } else {
            System.out.println(this.elements.get(this.currentIndex));
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index;
            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public String next() {
                return elements.get(index);
            }
        };
    }

    public void printAll() {
        if (this.elements.size() < 1) {
            throw new IllegalStateException("Invalid Operation!");
        } else {
            for (int i = 0; i < this.elements.size(); i++) {
                if(i == this.elements.size() - 1){
                    System.out.println(this.elements.get(i));
                } else {
                    System.out.print(this.elements.get(i) + " ");
                }
            }
        }
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        while(this.elements.iterator().hasNext()){
            action.accept(this.elements.iterator().next());
        }
    }
}
