package guru.qa.tests;

import guru.qa.pages.AuthModal;
import guru.qa.pages.MainPage;
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
@Tag("rusprofile")
public class LoginTests extends TestBaseRusprofile {
    AuthModal authPage = new AuthModal();
    MainPage mainPage = new MainPage();

    @Test
    @Disabled
    @DisplayName("Регистрация на Rusprofile")
    void registrationTest() {
        step("Открываем главную страницу", () -> {
            mainPage.openMainPage();
        });

        step("Кликаем на кнопку Войти", () -> {
            authPage.clickLoginBtn();
        });

        step("Кликаем на кнопку Зарегистрируйтесь", () -> {
            authPage.registrationClick();
        });

        step("Вводим Имя", () -> {
            authPage.setName("Anton");
        });

        step("Вводим почту", () -> {
            authPage.setEmail("Vova.zudov.1994@main.ru");
        });

        step("Вводим валидный пароль", () -> {
            authPage.setPass("QdysME4HFA12");
        });

        step("Принять условия сервиса, нажать на чекбокс", () -> {
            authPage.clickCheckboxCondition();
        });

        step("Нажать на кнопку Зарегистрироваться", () -> {
            authPage.clickRegistrationBtn();
        });

        step("Видим сообщение об успешной регистрации", () -> {
            authPage.examinationResultCheck();
        });
    }

    @Test
    @DisplayName("Успешный вход")
    void successLogin() {

        step("Открываем главную страницу", () -> {
            mainPage.openMainPage();
        });

        step("Кликаем на кнопку Войти", () -> {
            authPage.clickLoginBtn();
        });

        step("Вводим почту", () -> {
            authPage.setEmail("Vova.zudov.1994@main.ru");
        });

        step("Вводим валидный пароль", () -> {
            authPage.setPass("QdysME4HFA12");
        });

        step("Нажимаем на кнопку Войти", () -> {
            authPage.clickSubmitBtn();
        });
    }

    @Test
    @DisplayName("Вход с невалидным паролем")
    void wrongPassLogin() {

        step("Открываем главную страницу", () -> {
            mainPage.openMainPage();
        });

        step("Кликаем на кнопку Войти", () -> {
            authPage.clickLoginBtn();
        });

        step("Вводим почту", () -> {
            authPage.setEmail("Vova.zudov.1994@main.ru");
        });

        step("Вводим невалидный пароль", () -> {
            authPage.setPass("QdysME4HFA14");
        });

        step("Нажимаем на кнопку Войти", () -> {
            authPage.clickSubmitBtn();
        });

        step("Видим сообщение ошибки", () -> {
            authPage.checkFailedPass();
        });

    }

    @Test
    @DisplayName("Вход с невалидной почтой")
    void wrongMailLogin() {

        step("Открываем главную страницу", () -> {
            mainPage.openMainPage();
        });

        step("Кликаем на кнопку Войти", () -> {
            authPage.clickLoginBtn();
        });

        step("Вводим не верный почтовый адрес", () -> {
            authPage.setEmail("Vova.zudov.1995@main.ru");
        });

        step("Вводим валидный пароль", () -> {
            authPage.setPass("QdysME4HFA12");
        });

        step("Нажимаем на кнопку Войти", () -> {
            authPage.clickSubmitBtn();
        });

        step("Видим сообщение ошибки", () -> {
            authPage.checkFailedEmail();
        });

    }

}