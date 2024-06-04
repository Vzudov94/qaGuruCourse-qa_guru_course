package qa.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class toolsDZTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        //Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 9000; //default 4000
}

    @Test
    void testFillForm(){
        open("https://demoqa.com/automation-practice-form");
        $x("//*[@id='firstName']").setValue("Vova");
        $("#lastName").setValue("Zudov");
        $("#userEmail").setValue("vzudov@samokat.ru");
        $("#genterWrapper").$(byText("Male")).click();
        //$("#gender-radio-1").click();
        //getSelectedRadio(By.name("gender-radio-1"));
        $("#userNumber").setValue("89065058712");
        //$("#dateOfBirthInput").click();
        //$("[class=react-datepicker__month-select]").selectOption("March");
        //$("[class=react-datepicker__year-select]").selectOption("1998");
        //$("[class=react-datepicker__input-container]").$("[class=react-datepicker__day react-datepicker__day--012]").click();
        //$(withText("react-datepicker__day--017")).click();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#currentAddress").setValue("Msk");
        //$("#stateCity-wrapper").$(byText("Select State")).click();
        //$("#stateCity-wrapper").$(byText("Select State")).setValue("Rajasthan").click();
        //$("#stateCity-wrapper").$(byText("Select State")).$(byText("Rajasthan")).pressEnter();
        //$("#stateCity-wrapper").$("[class=css-1uccc91-singleValue]").setValue("Agra").pressEnter();
        $("#submit").click();

    }
}


