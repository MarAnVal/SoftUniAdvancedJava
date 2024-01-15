package Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    //- title: String
    private String title;
    //- year: int
    private int year;
    //- authors: List<String>
    private List<String> authors;
    //- setTitle(String)
    public void setTitle(String title) {
        this.title = title;
    }
    //- setYear(String)
    public void setYear(int year) {
        this.year = year;
    }
    //- setAuthors(String…)

    public void setAuthors(String... author) {
        this.authors = new ArrayList<>(Arrays.asList(author));
    }
    //+ getTitle(): String
    //+ getYear(): int
    //+ getAuthors(): List<String>
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public List<String> getAuthors() {
        return authors;
    }

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", authors=" + authors +
                '}';
    }
}
