import java.util.ArrayList;
import java.util.List;

public class BookManager implements BookOperations {
    private List<Book> ksiazki;

    public BookManager(List<Book> ksiazki) {
        this.ksiazki = ksiazki;
    }

    @Override
    public void dodajKsiazke(Book book) {
        ksiazki.add(book);
    }

    @Override
    public void usunKsiazke(Book book) {
        ksiazki.remove(book);
    }

    @Override
    public void zaktualizujKsiazke(Book staraKsiazka, Book nowaKsiazka) {
        int index = ksiazki.indexOf(staraKsiazka);
        if (index != -1) {
            ksiazki.set(index, nowaKsiazka);
        }
    }

    @Override
    public List<Book> pobierzKsiazki() {
        return new ArrayList<>(ksiazki);
    }
}
