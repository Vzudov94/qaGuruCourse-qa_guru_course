package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthModal {
    private final SelenideElement

            loginBtn = $(byText("Войти")),
            clickRegistrationLink = $(byText("Зарегистрируйтесь")),
            inputName = $("input[placeholder='Ваше имя']"),
            inputEmail = $(By.name("fome_email")),
            inputPassword = $(By.name("form_pass")),
            registrationBtn = $("[class='btn btn-blue btn-wide']"),
            checkboxCondition =$(".checkbox-label"),
            successRegistrationMessage = $(byText("Вы зарегистрированы")),
            clickSubmitBtn = $("[class='btn btn-blue']"),
            failedPasswordMessage = $(byText("Неправильный пароль. Попробуйте еще раз.")),
            failedEmailMessage = $(byText("Пользователь не найден"));


    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void registrationClick() {
        clickRegistrationLink.click();
    }

    public void setName(String value) {
        inputName.setValue(value);
    }

    public void setEmail(String value) {
        inputEmail.setValue(value);
    }

    public void setPassword(String value) {
        inputPassword.setValue(value);
    }

    public void clickRegistrationBtn() {
        registrationBtn.click();
    }

    public void clickCheckboxCondition() {
        new Actions(WebDriverRunner.getWebDriver()).moveToElement($(checkboxCondition).toWebElement(), 10, 10) .click() .build() .perform();
    }

    public void successRegistrationMessageCheck() {
        successRegistrationMessage.shouldBe(exist);
    }

    public void clickSubmitBtn() {
        clickSubmitBtn.click();
    }

    public void checkFailedPass() {
        failedPasswordMessage.shouldBe(exist);
    }

    public void checkFailedEmail() {
        failedEmailMessage.shouldBe(exist);
    }

}