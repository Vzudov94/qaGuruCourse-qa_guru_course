package qa.qa;

import Peges.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class toolsDZTestsPegeObjectsTest {

    RegistrationPage registrationPage = new RegistrationPage();
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
        registrationPage.openPage()
        .setFirstName("Vova")
        .setLastName("Zudov")
        .setEmail("vzudov@samokat.ru")
        .setGenter("Male")
        .setUserNumberInput("89065058712")
        .setDateOfBirth ( "21",  "March",  "1998")
        .setSubjectsInput ("Commerce")
        .setHobbiesWrapper ("Sports")
        .setCurrentAddress ("Msk")
        .setStateInput ("Rajasthan")
        .setCityInput("Jaiselmer")
        .setSubmitClick("submit");
    }
}


