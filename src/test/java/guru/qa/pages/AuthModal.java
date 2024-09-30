package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthModal {
    private final SelenideElement

            loginBtn = $(byText("Войти")),
            registrationClick = $(byText("Зарегистрируйтесь")),
            inputName = $("input[placeholder='Ваше имя']"),
            inputEmail = $(By.name("fome_email")),
            inputPass = $(By.name("form_pass")),
            registrationBtn = $("[class='btn btn-blue btn-wide']"),
            checkboxCondition = $("[class='checkbox-label'"),
            examinationResault = $(byText("Вы зарегистрированы")),
            gateBtn = $("[class='btn btn-blue']"),
            failedPass = $(byText("Неправильный пароль. Попробуйте еще раз.")),
            failedEmail = $(byText("Пользователь не найден"));


    public AuthModal clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    public AuthModal registrationClick() {
        registrationClick.click();
        return this;
    }

    public AuthModal setName(String value) {
        inputName.setValue(value);
        return this;
    }

    public AuthModal setEmail(String value) {
        inputEmail.setValue(value);
        return this;
    }

    public AuthModal setPass(String value) {
        inputPass.setValue(value);
        return this;
    }

    public AuthModal clickRegistrationBtn() {
        registrationBtn.click();
        return this;
    }

    public AuthModal clickСheckboxСondition() {
        checkboxCondition.click();
        return this;
    }

    public AuthModal examinationResaultCheck() {
        examinationResault.shouldBe(exist);
        return this;
    }

    public AuthModal clickSubmitBtn() {
        gateBtn.click();
        return this;
    }

    public AuthModal checkFailedPass() {
        failedPass.shouldBe(exist);
        return this;
    }

    public AuthModal checkFailedEmail() {
        failedEmail.shouldBe(exist);
        return this;
    }

}
