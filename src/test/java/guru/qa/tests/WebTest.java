package guru.qa.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {
    @BeforeEach
    void setUp() {
        open("https://duckduckgo.com/");
    }

    @Test
    @Tag("BLOCKER")
    @DisplayName("Для поискового запроса 'Car' должен отдавать не пустой список карточек")
    void successfulSearchTest() {
        $("[name=q]")
                .setValue("Car")
                .pressEnter();
        $x("//*[@class='XvPRmQVeIoCP5lQhICTv DrcNDXeWs90rE8UOUh96']//li[4]").click();
        $$("[class*='result result--news']").shouldBe(sizeGreaterThan(1));
    }
}

