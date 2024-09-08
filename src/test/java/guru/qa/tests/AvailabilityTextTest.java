package guru.qa.tests;

import guru.qa.pages.AuthPage;
import guru.qa.pages.AvailabilityTextPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Epic("Проверка заголовка Rusprofile")
@Feature("Проверка названия заголовка раздела на Rusprofile")
@DisplayName("Проверка названия заголовка раздела на Rusprofile")
@TmsLink("HOMEWORK-1")
@Tag("Rusprofile")
public class AvailabilityTextTest extends TestBaseRusprofile {
    AuthPage authPage = new AuthPage();
    AvailabilityTextPage availabilityTextPage = new AvailabilityTextPage();

    @Test
    @DisplayName("Проверка правильности поискового запроса")
    void checkAvailabilityTextTest() {

        step("Открываем главную страницу", () -> {
            authPage.openPage();
        });

        step("Нажать на вкладку Проверка физлиц", () -> {
            availabilityTextPage.tabFizFace();
        });

        step("Перейти в раздел Частным лицам", () -> {
            availabilityTextPage.transitionSection();
        });

        step("Прокрутить страницу до нужного раздела", () -> {
            availabilityTextPage.goToScrollElement();
        });

        step("Убедиться, что есть раздел Покупаете недвижимость или авто", () -> {
            availabilityTextPage.availabilityText();
        });
    }
}
