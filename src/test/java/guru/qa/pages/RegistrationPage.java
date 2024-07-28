package guru.qa.pages;

import guru.qa.pages.components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailinput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#state input"),
            cityInput = $("#city input"),
            submitClick = $("#submit"),
            checkResult = $(".table-responsive");
    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailinput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;

    }

    public RegistrationPage setDateOfBirth(String day, String mouth, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, mouth, year);

        return this;

    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setStateInput(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCityInput(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage ClickSubmit(String value) {
        submitClick.click();
        return this;
    }

    public RegistrationPage checkResult (String key ,String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public SelenideElement getCheckResult() {
        return checkResult;
    }
}

