package guru_qa.qa_guru_allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambodaFuncTest {
    private static final String repository = "vskltsv/demoqa_homework";
    private static final int issue = 3;

    @Test
    public void testIssueSearchLambda() {


        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("В поле поиска вводим название репозитория", () -> {
            $(".header-search-input").setValue(repository).pressEnter();
        });

        step("Кликаем по ссылке репозитория " + issue, () -> {
            $(linkText(repository)).click();
        });

        step("Кликаем на вкладку issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие Issue с id - #3 " + issue, () -> {
            $(withText("#" + issue)).should(Condition.exist);
        });

        attachment("Source", webdriver().driver().source());


    }

    @Test
    public void testAnnotatedStep() {
        AnnotatedStep webSteps = new AnnotatedStep();

        webSteps.openPage()
                .searchForRepository(repository)
                .clickOnRepositoryLink(repository)
                .openIssuesTab()
                .shouldSeeIssueWithNumber(issue);
        webSteps.takeScreenshot();

    }
}
