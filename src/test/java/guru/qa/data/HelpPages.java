package guru.qa.data;

public enum HelpPages {
    ACCOUNT("Работа с ЛК"),
    CARD("Карта/наличные"),
    RESTRICTIONS("Ограничения");

    public final String title;

    HelpPages(String title) {
        this.title = title;

    }
}