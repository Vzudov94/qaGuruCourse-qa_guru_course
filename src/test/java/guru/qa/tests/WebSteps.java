package guru.qa.tests;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public WebSteps openMainPage() {
        open("http://github.com");
        return this;
    }

    @Step("Ищем репозиторий {repo}")
    public WebSteps searchForRepository(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
        return this;

    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public WebSteps clickRepositoryLink(String repo) {
        $(linkText(repo)).click();
        return this;
    }

    @Step("Открываем таб issues")
    public WebSteps openIssuesTab() {
        $("#issues-tab").click();
        return this;
    }

    @Step("Проверяем наличие issues с номером {issue}")
    public WebSteps shouldSeeIssuesWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
        return this;
    }
}
