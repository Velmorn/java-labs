package entity;

public class Book {
    private int id;
    private String title;
    private int year;
    private int quantity;
    private int authorId;
    private int genreId;

    public Book() {
    }

    public Book(String title, int year, int quantity, int authorId, int genreId) {
        this.title = title;
        this.year = year;
        this.quantity = quantity;
        this.authorId = authorId;
        this.genreId = genreId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", quantity=" + quantity +
                ", authorId=" + authorId +
                ", genreId=" + genreId +
                '}';
    }
}
