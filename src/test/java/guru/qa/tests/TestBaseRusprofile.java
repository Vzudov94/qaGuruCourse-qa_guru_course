package guru.qa.tests;

import guru.qa.Config.DriverConfig;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBaseRusprofile {
    @BeforeAll
    public static void beforeAll() {
        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = System.getProperty("browserRemoteUrl", driverConfig.browserRemoteUrl());
        Configuration.browserSize = System.getProperty("browserSize", driverConfig.browserSize());
        Configuration.browserVersion = System.getProperty("browserVersion", driverConfig.browserVersion());
        Configuration.browser = System.getProperty("browser", driverConfig.browserName());
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("LastScreenshots");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}