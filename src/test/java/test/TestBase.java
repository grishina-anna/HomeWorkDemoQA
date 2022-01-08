package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import guru.qa.pages.RegistrationPage;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage(); //задаем новый объект

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }
}
