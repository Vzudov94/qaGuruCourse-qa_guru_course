package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Feature("ISSUE в репозитории")
@Story("Создание ISSUE")
public class StepTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @Test
    @Owner("vzudov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing")
    @DisplayName("Создание ISSUE для авторизованного пользователя")
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("http://github.com");
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#query-builder-test").submit();
        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();

        $(withText("#80")).should(Condition.exist);
    }

    @Test
    @Owner("vzudov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing")
    @DisplayName("Создание ISSUE для авторизованного пользователя")
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("http://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });

        step("Кликаем по ссылке репозитория" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие issues с номером" + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    @Owner("vzudov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing")
    @DisplayName("Создание ISSUE для авторизованного пользователя")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps gitHubsteps = new WebSteps();

        gitHubsteps.openMainPage()
                .searchForRepository(REPOSITORY)
                .clickRepositoryLink(REPOSITORY)
                .openIssuesTab()
                .shouldSeeIssuesWithNumber(ISSUE);
    }
}