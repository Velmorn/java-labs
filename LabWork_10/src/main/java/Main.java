/*
    Написати Java-програму, за допомогою якої реалізувати базові CRUD-операції.
    - бібліотека: автори(ід, ім'я), книги(ід, назва, рік, кількість), жанри (ід, назва)
*/

import DAO.AuthorDAO;
import DAO.BookDAO;
import DAO.DBConnection;
import DAO.GenreDAO;
import entity.Author;
import entity.Book;
import entity.Genre;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Підключення успішне!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            AuthorDAO authorDAO = new AuthorDAO();
            GenreDAO genreDAO = new GenreDAO();
            BookDAO bookDAO = new BookDAO();

            Author author = new Author("Шевченко");
            Genre genre = new Genre("Поезія");

            authorDAO.create(author);
            genreDAO.create(genre);

            System.out.println("=== Після CREATE ===");
            System.out.println("Authors: " + authorDAO.getAll());
            System.out.println("Genres: " + genreDAO.getAll());

            Book book = new Book(
                    "Кобзар",
                    1840,
                    10,
                    3,
                    3
            );

            bookDAO.create(book);

            System.out.println("Books: " + bookDAO.getAll());

            System.out.println("\n=== UPDATE ===");

            Author updatedAuthor = new Author(1, "Тарас Шевченко");
            authorDAO.update(updatedAuthor);

            Genre updatedGenre = new Genre(1, "Українська поезія");
            genreDAO.update(updatedGenre);

            Book updatedBook = new Book(
                    "Кобзар (оновлений)",
                    1845,
                    25,
                    3,
                    3
            );
            updatedBook.setId(4);
            bookDAO.update(updatedBook);

            System.out.println("Authors після UPDATE: " + authorDAO.getAll());
            System.out.println("Genres після UPDATE: " + genreDAO.getAll());
            System.out.println("Books після UPDATE: " + bookDAO.getAll());


            System.out.println("\n=== DELETE ===");

            bookDAO.delete(4);
            authorDAO.delete(3);
            genreDAO.delete(3);

            System.out.println("Authors після DELETE: " + authorDAO.getAll());
            System.out.println("Genres після DELETE: " + genreDAO.getAll());
            System.out.println("Books після DELETE: " + bookDAO.getAll());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
