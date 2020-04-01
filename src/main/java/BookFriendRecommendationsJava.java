import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookFriendRecommendationsJava {
    public static List<Movie> bookAdaptations(String author) {
        if (author.equals("Tolkien")) {
            return Arrays.asList(new Movie("An Unexpected Journey"),
                    new Movie("The Desolation of Smaug"));
        } else return Collections.emptyList();
    }

    public static List<String> recommendationFeed(List<Book> books) {
        List<String> result = new ArrayList<>();
        for (Book book : books)
            for (String author : book.authors)
                for (Movie movie : bookAdaptations(author)) {
                    result.add(String.format(
                            "You may like %s, because you liked %s’s %s",
                            movie.title, author, book.title));
                }
        return result;
    }

    public static void main(String[] args) {
        var books = Arrays.asList(new Book("FP in Scala", Arrays.asList("Chiusano", "Bjarnason")),
                new Book("The Hobbit", Arrays.asList("Tolkien")));
        System.out.println(recommendationFeed(books));
    }
}

class Book {
    final String title;
    final List<String> authors;

    Book(String title, List<String> authors) {
        this.title = title;
        this.authors = authors;
    }
}

class Movie {
    final String title;

    Movie(String title) {
        this.title = title;
    }
}
