package Peges;

import Peges.Components.CalendarComponent;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailinput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#state input"),
            cityInput = $("#city input"),
            submitClick = $("#submit");
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

    public RegistrationPage setGenter(String value) {
        genterWrapper.$(byText(value)).click();
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

    public RegistrationPage setSubmitClick(String value) {
        submitClick.click();
        return this;
    }
}

    //public RegistrationPage cheeckResult (String key,String value){
        //submit.se(value).click();
        //return this;}



