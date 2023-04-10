package staticPO.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage extends BasePage {

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");
    private static By messageError = By.cssSelector("[class='notice errors']");
    private static By successMessage = By.cssSelector("[class='notice success']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void attemptLogin(String username, String password) {
        $(emailInput).shouldBe(Condition.exist).sendKeys(username);
        $(passwordInput).shouldBe(Condition.exist).sendKeys(password);
        $(loginButton).shouldBe(Condition.exist).click();
    }

    public String getMessageError() {
        return $(messageError).shouldBe(Condition.exist).getText();

    }

    public String getMessageSuccess() {
        ElementsCollection collect = $$(successMessage);





        return $(successMessage).shouldBe(Condition.exist).getText();
    }
}
