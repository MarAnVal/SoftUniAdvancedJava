package Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake implements Iterable<Integer> {
    private List<Integer> lake;

    public Lake(String... elements) {
        this.lake = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            lake.add(Integer.parseInt(elements[i]));
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        int count = -2;

        @Override
        public boolean hasNext() {
            if (count + 2 >= lake.size() && count % 2 == 0) {
                count = -1;
            }
            return count + 2 < lake.size();
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                count += 2;
                return lake.get(count);
            } else {
                return null;
            }
        }

        @Override
        public void forEachRemaining(Consumer<? super Integer> action) {
            Iterator.super.forEachRemaining(action);
        }
    }
}
