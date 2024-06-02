import java.util.List;

public interface BookOperations {
    void dodajKsiazke(Book book);
    void usunKsiazke(Book book);
    void zaktualizujKsiazke(Book staraKsiazka, Book nowaKsiazka);
    List<Book> pobierzKsiazki();
}
