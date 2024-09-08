package guru.qa.tests;

import guru.qa.pages.AuthPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Epic("Авторизация Rusprofile")
@Feature("Проверка отображения окна авторизации Rusprofile")
@DisplayName("Проверка отображения окна авторизации Rusprofile")
@TmsLink("HOMEWORK-1")
@Tag("Rusprofile")
public class EntranceRusprofileTest extends TestBaseRusprofile {
    AuthPage authPage = new AuthPage();

    @Test
    @Disabled
    @DisplayName("Регистрация на Rusprofile")
    void rusprofileRegistrationTest() {
        step("Открываем главную страницу", () -> {
            authPage.openPage();
        });

        step("Кликаем на кнопку Войти", () -> {
            authPage.entranceLogin();
        });

        step("Кликаем на кнопку Зарегистрируйтесь", () -> {
            authPage.registrationClick();
        });

        step("Вводим Имя", () -> {
            authPage.setInputName("Anton");
        });

        step("Вводим почту", () -> {
            authPage.setInputEmail("Vova.zudov.1994@main.ru");
        });

        step("Вводим валидный пароль", () -> {
            authPage.setInputPass("QdysME4HFA12");
        });

        step("Принять условия сервиса, нажать на чекбокс", () -> {
            authPage.clickCheckbox();
        });

        step("Нажать на кнопку Зарегистрироваться", () -> {
            authPage.clickFinal();
        });

        step("Видим сообщение об успешной регистрации", () -> {
            authPage.examinationResaultCheck();
        });
    }

    @Test
    @DisplayName("Успешный вход")
    void rusprofilePassedEntrance() {

        step("Открываем главную страницу", () -> {
            authPage.openPage();
        });

        step("Кликаем на кнопку Войти", () -> {
            authPage.entranceLogin();
        });

        step("Вводим почту", () -> {
            authPage.setInputEmail("Vova.zudov.1994@main.ru");
        });

        step("Вводим валидный пароль", () -> {
            authPage.setInputPass("QdysME4HFA12");
        });

        step("Нажимаем на кнопку Войти", () -> {
            authPage.finalEntranceClick();
        });
    }

    @Test
    @DisplayName("Вход с невалидным паролем")
    void rusprofileFailedPassEntrance() {

        step("Открываем главную страницу", () -> {
            authPage.openPage();
        });

        step("Кликаем на кнопку Войти", () -> {
            authPage.entranceLogin();
        });

        step("Вводим почту", () -> {
            authPage.setInputEmail("Vova.zudov.1994@main.ru");
        });

        step("Вводим невалидный пароль", () -> {
            authPage.setInputPass("QdysME4HFA14");
        });

        step("Нажимаем на кнопку Войти", () -> {
            authPage.finalEntranceClick();
        });

        step("Видим сообщение ошибки", () -> {
            authPage.examinationFailedPassResaultCheck();
        });

    }

    @Test
    @DisplayName("Вход с невалидной почтой")
    void rusprofileFailedEmailEntrance() {

        step("Открываем главную страницу", () -> {
            authPage.openPage();
        });

        step("Кликаем на кнопку Войти", () -> {
            authPage.entranceLogin();
        });

        step("Вводим не верный почтовый адрес", () -> {
            authPage.setInputEmail("Vova.zudov.1995@main.ru");
        });

        step("Вводим валидный пароль", () -> {
            authPage.setInputPass("QdysME4HFA12");
        });

        step("Нажимаем на кнопку Войти", () -> {
            authPage.finalEntranceClick();
        });

        step("Видим сообщение ошибки", () -> {
            authPage.examinationFailedEmailResaultCheck();
        });

    }
}