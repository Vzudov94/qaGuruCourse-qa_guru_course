package guru.qa.tests;

import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationRemoteTests extends TestBase {
    @AfterEach
    void addAttachments() {
        Attach.screenshots("Last screenshots");
        Attach.pageSource();
        Attach.browserConsologLogs();
        Attach.addVideo();
    }

    @Test
    @Tag("simple")
    void remoteTests() {
        open("/automation-practice-form");
        $x("//*[@id='firstName']").setValue("Vova");
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
        $("#currentAddress").setValue("Msk");
        $("#state input").setValue("Rajasthan").pressEnter();
        $("#city input").setValue("Jaiselmer").pressEnter();
        $("#submit").click();

    }
}