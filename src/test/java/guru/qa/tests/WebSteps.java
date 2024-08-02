package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    private final String GITHUB_URL = "http://github.com";
    private final SelenideElement searchInput = $(".header-search-button"),
    digSearchInput=$("#query-builder-test");
    @Step("Открываем главную страницу")
    public WebSteps openMainPage() {
        open(GITHUB_URL);
        return this;
    }

    @Step("Ищем репозиторий {repo}")
    public WebSteps searchForRepository(String repo) {
        searchInput.click();
        digSearchInput.setValue(repo).submit();
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
