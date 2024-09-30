package guru.qa.tests;

import guru.qa.pages.MainPage;
import guru.qa.pages.SearchPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Epic("Проверка поиска на Rusprofile")
@Feature("Проверка корректности поискового запроса на Rusprofile")
@DisplayName("Проверка корректности поискового запроса на Rusprofile")
@TmsLink("HOMEWORK-1")
@Tag("rusprofile")
public class SearchTests extends TestBaseRusprofile {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Test
    @DisplayName("Проверка правильности поискового запроса")
    void searchResult() {
        step("Открываем главную страницу", () -> {
            mainPage.openMainPage();
        });

        step("В поисковом запросе вписываем критерий поиска", () -> {
            searchPage.fillSearchInput("Оценка+");
        });

        step("Проверка результата поискового запроса", () -> {
            searchPage.requestVerification("Оценка+");
        });
    }
}
