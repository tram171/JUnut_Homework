package guru.qa.data;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NsuWebTest {

    @EnumSource(Languages.class)
    @ParameterizedTest
    void nsuSiteShouldDisplayCorrectNewsTitle(Languages language) {
        open("https://www.nsu.ru/n/");

        $("[href='/n/switch-lang/?" + language.hrefSuffix + "']").click();
        $("body").shouldHave(text(language.newsTitle));
    }


}
