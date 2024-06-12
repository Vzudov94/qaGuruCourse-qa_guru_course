package qa.qa;

import Peges.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    String firstNameLocator ="#.firstName";
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        //Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 9000; //default 4000
}

    @Test
    void succesfulRegistrationTest(){
        open("https://demoqa.com/automation-practice-form");
        new RegistrationPage().setFirstName("Vova");
        new RegistrationPage().setFirstName("Vova");
        $("#lastName").setValue("Zudov");
        $("#userEmail").setValue("vzudov@samokat.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89065058712");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__month-select]").selectOption("March");
        $("[class=react-datepicker__year-select]").selectOption("1998");
        $(".react-datepicker__day--021:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        //$("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Msk");
        $("#state input").setValue("Rajasthan").pressEnter();
        $("#city input").setValue("Jaiselmer").pressEnter();
        $("#submit").click();

    }
}



