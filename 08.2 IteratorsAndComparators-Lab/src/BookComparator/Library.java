package BookComparator;

import java.util.Iterator;
import java.util.function.Consumer;

public class Library<Book> implements Iterable<Book> {
    //- books: Book[]
    private Book[] books;
    //+ iterator(): Iterator<Book>

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private class LibIterator implements Iterator<Book> {
        private int counter;

        public LibIterator() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return this.counter < books.length;
        }

        @Override
        public Book next() {
            return books[this.counter++];
        }


    }


}
