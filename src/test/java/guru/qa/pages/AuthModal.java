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
            examinationResult = $(byText("Вы зарегистрированы")),
            gateBtn = $("[class='btn btn-blue']"),
            failedPass = $(byText("Неправильный пароль. Попробуйте еще раз.")),
            failedEmail = $(byText("Пользователь не найден"));


    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void registrationClick() {
        registrationClick.click();
    }

    public void setName(String value) {
        inputName.setValue(value);
    }

    public void setEmail(String value) {
        inputEmail.setValue(value);
    }

    public void setPass(String value) {
        inputPass.setValue(value);
    }

    public void clickRegistrationBtn() {
        registrationBtn.click();
    }

    public void clickCheckboxCondition() {
        checkboxCondition.click();
    }

    public void examinationResultCheck() {
        examinationResult.shouldBe(exist);
    }

    public void clickSubmitBtn() {
        gateBtn.click();
    }

    public void checkFailedPass() {
        failedPass.shouldBe(exist);
    }

    public void checkFailedEmail() {
        failedEmail.shouldBe(exist);
    }

}
