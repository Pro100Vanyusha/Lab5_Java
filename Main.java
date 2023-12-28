import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Catalog {

    // Внутрішній клас для представлення історії видачі книги читачам
    public static class BookHistory {
        private String читач;
        private Date датаВидачі;
        private Date датаПовернення;

        public BookHistory(String читач, Date датаВидачі, Date датаПовернення) {
            this.читач = читач;
            this.датаВидачі = датаВидачі;
            this.датаПовернення = датаПовернення;
        }

        @Override
        public String toString() {
            return "Читач: " + читач + ", Дата видачі: " + датаВидачі + ", Дата повернення: " + датаПовернення;
        }
    }

    private String назваКниги;
    private List<BookHistory> історіяВидачі;

    public Catalog(String назваКниги) {
        this.назваКниги = назваКниги;
        this.історіяВидачі = new ArrayList<>();
    }

    // Метод для додавання запису про видачу книги
    public void видачаКниги(String читач, Date датаВидачі, Date датаПовернення) {
        BookHistory новаИсторія = new BookHistory(читач, датаВидачі, датаПовернення);
        історіяВидачі.add(новаИсторія);
    }

    // Метод для отримання історії видачі книги
    public List<BookHistory> отриматиІсторіюВидачі() {
        return історіяВидачі;
    }

    // Метод для виведення інформації про книгу та її історії видачі
    public void вивестиІнформацію() {
        System.out.println("Інформація про книгу '" + назваКниги + "':");
        System.out.println("Історія видачі:");

        for (BookHistory історія : історіяВидачі) {
            System.out.println(історія.toString());
        }
    }

    public static void main(String[] args) {
        // Приклад використання класу Catalog та його внутрішнього класу BookHistory
        Catalog книжковийКаталог = new Catalog("Пригоди Тома Сойєра");

        // Симулюємо видачу книги
        книжковийКаталог.видачаКниги("Іванов І.І.", new Date(), null);

        // Симулюємо повернення книги
        книжковийКаталог.видачаКниги("Петров П.П.", new Date(), new Date());

        // Отримуємо та виводимо історію видачі
        List<BookHistory> історія = книжковийКаталог.отриматиІсторіюВидачі();
        for (BookHistory історіяВидачі : історія) {
            System.out.println(історіяВидачі.toString());
        }

        // Виводимо загальну інформацію про книгу та її історію видачі
        книжковийКаталог.вивестиІнформацію();
    }
}
