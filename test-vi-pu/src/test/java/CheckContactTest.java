import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CheckContactTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void contactsMenuItemShouldOpenContactsPage() {
        // Arrange
        driver.get("https://vi-pu.ru/");

        // Act
        WebElement contactsLink = driver.findElement(
                By.linkText("Контакты")
        );

        contactsLink.click();

        String currentUrl = driver.getCurrentUrl();

        String heading = driver
                .findElement(By.tagName("h1"))
                .getText()
                .trim();

        // Assert
        assertTrue(
                currentUrl.contains("kontakty"),
                "URL должен вести на страницу контактов"
        );

        assertEquals(
                "Контакты",
                heading,
                "На странице должен быть заголовок «Контакты»"
        );
    }
}