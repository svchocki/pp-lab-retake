import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static BookManager bookManager;

    public static void main(String[] args) {
        List<Book> poczatkoweKsiazki = new ArrayList<>();
        poczatkoweKsiazki.add(new Book("Tytul1", "Autor1", "ISBN1", 2001));
        poczatkoweKsiazki.add(new Book("Tytul2", "Autor2", "ISBN2", 2002));
        poczatkoweKsiazki.add(new Book("Tytul3", "Autor3", "ISBN3", 2003));
        poczatkoweKsiazki.add(new Book("Tytul4", "Autor4", "ISBN4", 2004));
        poczatkoweKsiazki.add(new Book("Tytul5", "Autor5", "ISBN5", 2005));
        
        bookManager = new BookManager(poczatkoweKsiazki);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[1] Dodaj książkę");
            System.out.println("[2] Usuń książkę");
            System.out.println("[3] Zaktualizuj książkę");
            System.out.println("[4] Lista książek");
            System.out.println("[5] Wyjście");
            System.out.print("Wybierz opcję: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    dodajKsiazke(scanner);
                    break;
                case 2:
                    usunKsiazke(scanner);
                    break;
                case 3:
                    zaktualizujKsiazke(scanner);
                    break;
                case 4:
                    listaKsiazek();
                    break;
                case 5:
                    System.out.println("Wyjście...");
                    return;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        }
    }

    private static void dodajKsiazke(Scanner scanner) {
        System.out.print("Podaj tytuł: ");
        String tytul = scanner.nextLine();
        System.out.print("Podaj autora: ");
        String autor = scanner.nextLine();
        System.out.print("Podaj ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Podaj rok: ");
        int rok = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(tytul, autor, isbn, rok);
        bookManager.dodajKsiazke(book);
        System.out.println("Książka dodana pomyślnie.");
    }

    private static void usunKsiazke(Scanner scanner) {
        System.out.print("Podaj ISBN książki do usunięcia: ");
        String isbn = scanner.nextLine();

        Book book = bookManager.pobierzKsiazki().stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);

        if (book != null) {
            bookManager.usunKsiazke(book);
            System.out.println("Książka usunięta pomyślnie.");
        } else {
            System.out.println("Nie znaleziono książki.");
        }
    }

    private static void zaktualizujKsiazke(Scanner scanner) {
        System.out.print("Podaj ISBN książki do zaktualizowania: ");
        String isbn = scanner.nextLine();

        Book staraKsiazka = bookManager.pobierzKsiazki().stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);

        if (staraKsiazka != null) {
            System.out.print("Podaj nowy tytuł: ");
            String tytul = scanner.nextLine();
            System.out.print("Podaj nowego autora: ");
            String autor = scanner.nextLine();
            System.out.print("Podaj nowy rok: ");
            int rok = scanner.nextInt();
            scanner.nextLine();

            Book nowaKsiazka = new Book(tytul, autor, isbn, rok);
            bookManager.zaktualizujKsiazke(staraKsiazka, nowaKsiazka);
            System.out.println("Książka zaktualizowana pomyślnie.");
        } else {
            System.out.println("Nie znaleziono książki.");
        }
    }

    private static void listaKsiazek() {
        List<Book> ksiazki = bookManager.pobierzKsiazki();
        if (ksiazki.isEmpty()) {
            System.out.println("Brak dostępnych książek.");
        } else {
            ksiazki.forEach(System.out::println);
        }
    }
}
