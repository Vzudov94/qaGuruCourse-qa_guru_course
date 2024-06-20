package guru_qaTests;

import guru_qaPagesObject.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void testFillForm(){
        registrationPage.openPage()
        .setFirstName("Vova")
        .setLastName("Zudov")
        .setEmail("vzudov@samokat.ru")
        .setGender("Male")
        .setUserNumberInput("9065058713")
        .setDateOfBirth ( "21",  "March",  "1998")
        .setSubjectsInput ("Commerce")
        .setHobbiesWrapper ("Sports")
        .setCurrentAddress ("Msk")
        .setStateInput ("Rajasthan")
        .setCityInput("Jaiselmer")
        .ClickSubmit("submit")
        .checkResult("Student Name","Vova Zudov")
        .checkResult("Student Email","vzudov@samokat.ru")
        .checkResult("Gender","Male")
        .checkResult("Mobile","9065058713")
        .checkResult("Date of Birth","21 March,1998")
        .checkResult("Subjects","Commerce")
        .checkResult("Hobbies","Sports")
        .checkResult("Address","Msk")
        .checkResult("State and City","Rajasthan Jaiselmer");
    }
}


