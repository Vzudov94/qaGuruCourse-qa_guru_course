package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AvailabilityTextPage {
    private final SelenideElement
            tabFizFace = $(byText("Проверка физлиц")),
            tabPivateFace = $(byText("Частным лицам")),
            textBuyRealty = $(byText("Покупаете недвижимость или авто"));

    public void clickTabFizFace() {
        tabFizFace.click();
    }

    public void clickTabPivateFace() {
        tabPivateFace.click();
    }

    public void availabilityTextBuyRealty() {
        textBuyRealty.scrollIntoView(true).shouldBe(exist);
    }
}