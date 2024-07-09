package learning;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import static com.codeborne.selenide.Selenide.*;


public class alert_test {
    @Test
    public void check_creating_execution_and_deleting_task() {
        open("https://webdriveruniversity.com/Popup-Alerts/index.html");
        SelenideElement element = $("#button4");
        element.click();
        Alert alert = WebDriverRunner.getWebDriver().switchTo().alert();
        String alertText = alert.getText();
        assert alertText.equals("Press a button!");
        alert.accept();
        SelenideElement ok_text = $("#confirm-alert-text");
        String ok_str = ok_text.getText();
        assert ok_str.equals("You pressed OK!");

        element.click();
        Alert alert_dissmiss = WebDriverRunner.getWebDriver().switchTo().alert();
        alert_dissmiss.dismiss();
        SelenideElement cancel_text = $("#confirm-alert-text");
        String cancel_str = cancel_text.getText();
        assert cancel_str.equals("You pressed Cancel!");
    }
}
