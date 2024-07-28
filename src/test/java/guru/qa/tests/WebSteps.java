package guru.qa.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("http://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();

    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие issues с номером {issue}")
    public void shouldSeeIssuesWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }
}
