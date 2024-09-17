package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AvailabilityTextPage {
    private final SelenideElement
            tabFizFace = $(byText("Проверка физлиц")),
            tabPivateFace = $(byText("Частным лицам")),
            scrollElement = $(byText("Покупаете недвижимость или авто")),
            textBuyRealty = $(byText("Покупаете недвижимость или авто"));

    public AvailabilityTextPage clickTabFizFace() {
        tabFizFace.click();
        return this;
    }

    public AvailabilityTextPage clickTabPivateFace() {
        tabPivateFace.click();
        return this;
    }
    public AvailabilityTextPage goToScrollElement() {
        scrollElement.scrollTo();
        return this;
    }
    public AvailabilityTextPage availabilityTextBuyRealty() {
        textBuyRealty.shouldBe(exist);
        return this;
    }
}
