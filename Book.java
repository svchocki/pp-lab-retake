import java.util.Objects;

public class Book {
    private String tytul;
    private String autor;
    private String isbn;
    private int rok;

    public Book(String tytul, String autor, String isbn, int rok) {
        this.tytul = tytul;
        this.autor = autor;
        this.isbn = isbn;
        this.rok = rok;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return rok == book.rok &&
                Objects.equals(tytul, book.tytul) &&
                Objects.equals(autor, book.autor) &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tytul, autor, isbn, rok);
    }

    @Override
    public String toString() {
        return "Book{" +
                "tytul='" + tytul + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", rok=" + rok +
                '}';
    }
}
