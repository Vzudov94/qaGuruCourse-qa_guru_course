package guru.qa.tests;

import guru.qa.pages.AvailabilityTextPage;
import guru.qa.pages.MainPage;
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
@Tag("rusprofile")
public class AvailabilityTextTests extends TestBaseRusprofile {
    MainPage mainPage = new MainPage();
    AvailabilityTextPage availabilityTextPage = new AvailabilityTextPage();


    @Test
    @DisplayName("Проверка названия заголовка")
    void checkAvailabilityTextTest() {

        step("Открываем главную страницу", () -> {
            mainPage.openMainPage();
        });

        step("Нажать на вкладку Проверка физлиц", () -> {
            availabilityTextPage.clickTabFizFace();
        });

        step("Нажать на вкладку Частным лицам", () -> {
            availabilityTextPage.clickTabPivateFace();
        });

        step("Убедиться, что есть раздел Покупаете недвижимость или авто", () -> {
            availabilityTextPage.availabilityTextBuyRealty();
        });
    }
}