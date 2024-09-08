package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AvailabilityTextPage {
    private final SelenideElement
            clickTabFizFace = $(byText("Проверка физлиц")),
            clickTransitionSection = $(byText("Частным лицам")),
            scrollElement = $(byText("Покупаете недвижимость или авто")),
            checkAvailabilityText = $(byText("Покупаете недвижимость или авто"));

    public AvailabilityTextPage tabFizFace() {
        clickTabFizFace.click();
        return this;
    }

    public AvailabilityTextPage transitionSection() {
        clickTransitionSection.click();
        return this;
    }
    public AvailabilityTextPage goToScrollElement() {
        scrollElement.scrollTo();
        return this;
    }
    public AvailabilityTextPage availabilityText() {
        checkAvailabilityText.shouldBe(exist);
        return this;
    }
}
