package guru_qa.qa_guru_allure;
import  com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
public class AnnotatedStep {
    @Step("Открываем главную страницу")
    public AnnotatedStep openPage() {
        open("https://github.com");
        return this;
    }

    @Step("В поле поиска вводим название репозитория {repo}")
    public AnnotatedStep searchForRepository(String repo) {
        $(".header-search-input").setValue(repo).pressEnter();
        return this;
    }

    @Step("Кликаем по ссылке репозитория")
    public AnnotatedStep clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
        return this;
    }

    @Step("Кликаем на вкладку issues")
    public AnnotatedStep openIssuesTab() {
        $("#issues-tab").click();
        return this;
    }

    @Step("Проверяем наличие Issue с id - #3  {issue}")
    public AnnotatedStep shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
        return this;
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
