package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private final SelenideElement
            inputSearch = $("[class='index-search-input']"),
            examinationResult = $(byText("\"Оценка+\""));

    public SearchPage fillSearchInput(String value) {
        inputSearch.setValue(value).pressEnter();
        return this;
    }

    public SearchPage requestVerification(String value) {
        examinationResult.shouldHave(text(value));
        return this;
    }
}
