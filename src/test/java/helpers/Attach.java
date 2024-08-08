package helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import static com.codeborne.selenide.Selenide.sessionId;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attach {
    @Attachment(value = "(Lastscreenshot]", type = "image/png")
    public static byte[] screenshots(String Lastscreenshot) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "(TextMessage]", type = "text/plain")
    public static String attachAsText(String Textmessage, String message) {
        return message;
    }

    public static void browserConsologLogs() {
        attachAsText(
                "Browser console Logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = " .html")
    public static String addVideo() {
        return "‹html><body><video width= '100%' height= '100%' controls autoplay><source src='"
                + getVideoUrl()
                + "'type = 'video/mp4' ></video > s / body ></html > ";
    }

    public static URL getVideoUrl() {
        String videoUrt = "https://selenoid.autotests.cloud/video/" + sessionId() + ".mp4";
        try {
            return new URL(videoUrt);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
            return null;
        }
    }