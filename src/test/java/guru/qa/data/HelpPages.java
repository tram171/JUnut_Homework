package guru.qa.data;

public enum HelpPage {
    ACCOUNT("Высокий риск", "Высокий риск"),
    FNS_DATA_UPDATE("Мне обновили данные в ФНС. Какие документы вам нужны?", "Мне обновили данные в ФНС. Какие документы вам нужны?"),
    FNS_RESTRICTIONS("Как проверить ограничения на счёте?", "Как проверить ограничения на счёте?"),
    KARTOTEKA("Как погасить картотеку?", "Как погасить картотеку?"),
    PASSPORT_UPDATE("При обновлении паспорта. Что делать?", "При обновлении паспорта. Что делать?");

    public final String title;
    public final String expectedText;

    HelpPage(String title, String expectedText) {
        this.title = title;
        this.expectedText = expectedText;
    }
}