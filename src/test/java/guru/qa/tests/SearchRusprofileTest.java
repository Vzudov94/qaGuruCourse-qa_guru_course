package guru.qa.tests;

import guru.qa.pages.AuthPage;
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
@Tag("Rusprofile")
public class SearchRusprofileTest extends TestBaseRusprofile {
    AuthPage authPage = new AuthPage();
    SearchPage searchPage = new SearchPage();

    @Test
    @DisplayName("Проверка правильности поискового запроса")
    void searchResultTest() {
        step("Открываем главную страницу", () -> {
            authPage.openPage();
        });

        step("В поисковом запросе вписываем критерий поиска", () -> {
            searchPage.setInputSearch("Оценка+");
        });

        step("Проверка результата поискового запроса", () -> {
            searchPage.checkExaminationResult("Оценка+");
        });
    }

}
