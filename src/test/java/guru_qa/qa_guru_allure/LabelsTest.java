package guru_qa.qa_guru_allure;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class LabelsTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("VSokoltsov")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLabels() {
    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для авторизованного пользователя")
        );
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("Owner", "VSokoltsov");
        Allure.label("severity", SeverityLevel.NORMAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}
