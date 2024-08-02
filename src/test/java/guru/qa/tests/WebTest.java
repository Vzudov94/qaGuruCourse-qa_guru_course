package guru.qa.tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;


public class WebTest extends TestBase {
    @BeforeEach
    void setUp() {
        open("https://duckduckgo.com/");
    }

    @ValueSource(strings = {
            "Car", "Potato"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой список карточек")
    @Tag("BLOCKER")
    void successfulSearchTest(String searchQuery) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        $("[name=q]")
                .setValue(searchQuery)
                .pressEnter();
        $x("//*[@class='XvPRmQVeIoCP5lQhICTv DrcNDXeWs90rE8UOUh96']//li[4]").click();
        $$("[class*='result result--news']").shouldBe(sizeGreaterThan(1));
    }

    @Disabled
    @CsvSource(value = {
            "Car, https://vgtimes.ru/news/109941-poyavilos-novoe-video-avtosimulyatora-s-otkrytym-mirom-city-car-driving-2.0.html",
            "Potato, https://www.securitylab.ru/news/549993.php"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} в первой карточке должна быть ссылка {1}")
    @Tag("SMOKE")
    void searchResultsShouldContainExpectedUrl(String searchQuery, String expectedLink) {
        $("[name=q]")
                .setValue(searchQuery)
                .pressEnter();
        $x("//*[@class='XvPRmQVeIoCP5lQhICTv DrcNDXeWs90rE8UOUh96']//li[4]").click();
        $("[class*='result result--news']")
                .shouldHave(attribute("data-link", expectedLink));
    }
}