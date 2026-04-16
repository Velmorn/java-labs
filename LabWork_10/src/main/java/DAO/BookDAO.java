package DAO;

import entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void create(Book book) throws SQLException {
        String sql = """
                    INSERT INTO books(title, year, quantity, author_id, genre_id)
                    VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getYear());
            ps.setInt(3, book.getQuantity());
            ps.setInt(4, book.getAuthorId());
            ps.setInt(5, book.getGenreId());

            ps.executeUpdate();
        }
    }

    public List<Book> getAll() throws SQLException {
        String sql = "SELECT * FROM books";
        List<Book> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setYear(rs.getInt("year"));
                b.setQuantity(rs.getInt("quantity"));
                b.setAuthorId(rs.getInt("author_id"));
                b.setGenreId(rs.getInt("genre_id"));

                list.add(b);
            }
        }
        return list;
    }

    public void update(Book book) throws SQLException {
        String sql = """
                    UPDATE books
                    SET title=?, year=?, quantity=?, author_id=?, genre_id=?
                    WHERE id=?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getYear());
            ps.setInt(3, book.getQuantity());
            ps.setInt(4, book.getAuthorId());
            ps.setInt(5, book.getGenreId());
            ps.setInt(6, book.getId());

            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM books WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
