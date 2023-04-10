package staticPO.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import staticPO.pages.LoginPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;


public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    public void beforeClass(){
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.manage().deleteAllCookies();
    }

    @Test (priority = 0)
    public void unsuccessfulLoginTest() {
       ElementsCollection collection =  $$(By.xpath("//a//div[@class='name']"));
        List<String> list = collection.texts();

        for (String st:
             list) {
            System.out.println(st);
        }

        collection.shouldBe(CollectionCondition.containExactTextsCaseSensitive("Yellow Duck", "!Green Duck"));







        loginPage.attemptLogin("l.zubtsova@mail.ru", "14031Atc");
        String expectedMessage = "Wrong password or the account is disabled, or does not exist";

        Assert.assertEquals(expectedMessage,loginPage.getMessageError());
    }

    @Test (priority = 1)
    public void successfulLoginTest() {
        loginPage.attemptLogin("l.zubtsova@mail.ru", "14031993Atc");
        String expectedMessage = "You are now logged in as L Z.";

        Assert.assertEquals(expectedMessage,loginPage.getMessageSuccess());
    }

}
