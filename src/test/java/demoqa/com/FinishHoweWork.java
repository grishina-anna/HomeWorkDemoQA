package demoqa.com;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FinishHoweWork {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Grishina");
        $("#userEmail").setValue("aaa@aa.aa");
        $("#genterWrapper").$(byText("Female")).click(); //самый нормальный вариант
        $("#userNumber").setValue("8912345678");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(byText("29")).click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        File file = new File("src/test/resources/1.png");
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Krasnaya, 1-1-11");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();
    }
        @Test
        void shouldHave () {
            $(".modal-header").shouldHave(text("Thanks for submitting the form"));
            $(".modal-content").shouldHave(
                    text("Anna Grishina"),
                    text("aaa@aa.aa"),
                    text("Female"),
                    text("8912345678"),
                    text("29 July,1990"),
                    text("Math"),
                    text("Sports"),
                    text("img/1.png"),
                    text("Krasnaya, 1-1-11"),
                    text("NCR Noida"));
        }

    @AfterEach
    void AfterEach() {
        closeWebDriver();
    }
}

