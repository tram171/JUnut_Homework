import com.codeborne.selenide.Configuration;
import guru.qa.data.HelpPages;
import guru.qa.data.Partners;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BlancWebTest {

    @EnumSource(Partners.class)
    @ParameterizedTest
    @DisplayName("Корректные описания партнеров")
    @Tag("WEB")
    void integrationServiceHasCorrectDescription(Partners partner) {
        open("https://blanc.ru/integrations/");
        $(byText(partner.partnerName)).shouldBe(visible);
        $(byText(partner.description)).shouldBe(visible);
    }


    @CsvFileSource(resources = "/test_data/bankDetails.csv", delimiter = '|')
    @ParameterizedTest(name = "Реквизиты {0} соответствуют {1}")
    @DisplayName("Соответствие реквизитов банка")
    // @AllureId()
    @Tag("REGRESSION")
    void bankDetailsShouldMatch(String fieldName, String expectedValue) {
        open("https://blanc.ru/bank-details");
        $$(".adaptive-table__row")
                .findBy(text(fieldName))
                .shouldHave(text(expectedValue));
    }

    static Stream<Arguments> sectionShouldContainExpectedTexts() {
        return Stream.of(
                Arguments.of(
                        HelpPages.ACCOUNT,
                        List.of("Какие виды доступа есть?", "Как поменять номер телефона для входа?", "Что такое налоговая копилка? Для чего нужна?", "Можно ли дать сотруднику доступ к счёту?", "Что делать, если забыл пароль?", "Как скачать платёжные поручения, выписки и справки?")),
                Arguments.of(
                        HelpPages.CARD,
                        List.of("Где снять наличные?", "Что ещё мне нужно знать про карты?", "Что делать, если не помнишь пин-код?", "Какие лимиты у карты?")),
                Arguments.of(
                        HelpPages.RESTRICTIONS,
                        List.of("Высокий риск", "Мне обновили данные в ФНС. Какие документы вам нужны?", "Как погасить картотеку?", "Проверка деятельности компании", "Как снять ограничения от ФНС?", "При обновлении паспорта. Что делать?"))
        );
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("Статьи содержатся на странице")
    void sectionShouldContainExpectedTexts(HelpPages page, List<String> expectedButtons){
        Configuration.pageLoadTimeout = 60000;
        open("https://blanc.ru/help/");
        $(byText(page.title)).click();
        for (String expectedText : expectedButtons) {
            $("body").shouldHave(text(expectedText));
        }
    }
    }

