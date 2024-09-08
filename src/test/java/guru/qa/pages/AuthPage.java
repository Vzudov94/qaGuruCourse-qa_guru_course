package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AuthPage {

    private final SelenideElement

            entranceLogin = $(byText("Войти")),
            registrationclick = $(byText("Зарегистрируйтесь")),
            inputName = $("input[placeholder='Ваше имя']"),
            inputEmail = $(By.name("fome_email")),
            inputPass = $(By.name("form_pass")),
            finalClick = $("[class='btn btn-blue btn-wide']"),
            clickCheckbox = $("[class='checkbox-label'"),
            examinationResault = $(byText("Вы зарегистрированы")),
            entranceClick = $("[class='btn btn-blue']"),
            examinationFailedPassResault = $(byText("Неправильный пароль. Попробуйте еще раз.")),
            examinationFailedEmailResault = $(byText("Пользователь не найден"));


    public void openPage() {
        open("https://www.rusprofile.ru/");
    }

    public AuthPage entranceLogin() {
        entranceLogin.click();
        return this;
    }

    public AuthPage registrationClick() {
        registrationclick.click();
        return this;
    }

    public AuthPage setInputName(String value) {
        inputName.setValue(value);
        return this;
    }

    public AuthPage setInputEmail(String value) {
        inputEmail.setValue(value);
        return this;
    }

    public AuthPage setInputPass(String value) {
        inputPass.setValue(value);
        return this;
    }

    public AuthPage clickFinal() {
        finalClick.click();
        return this;
    }

    public AuthPage clickCheckbox() {
        clickCheckbox.click();
        return this;
    }

    public AuthPage examinationResaultCheck() {
        examinationResault.shouldBe(exist);
        return this;
    }

    public AuthPage finalEntranceClick() {
        entranceClick.click();
        return this;
    }

    public AuthPage examinationFailedPassResaultCheck() {
        examinationFailedPassResault.shouldBe(exist);
        return this;
    }

    public AuthPage examinationFailedEmailResaultCheck() {
        examinationFailedEmailResault.shouldBe(exist);
        return this;
    }

}
