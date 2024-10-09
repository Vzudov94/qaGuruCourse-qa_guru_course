package guru.qa.pages;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    public void openMainPage() {
        open("https://www.rusprofile.ru/");
    }
}