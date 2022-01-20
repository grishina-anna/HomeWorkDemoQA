package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.utils.RandomUtils.getRandomString;

public class FinishHoweWithTRandomUtilsWork extends TestBase {


    String firstName = getRandomString(12);

     @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
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

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(
                text(firstName + "Grishina"),
                text("aaa@aa.aa"),
                text("8912345678"),
                text("29 July,1990"),
                 text("Krasnaya, 1-1-11"),
                text("NCR Noida"));
    }

    @AfterEach
    void AfterEach() {
        closeWebDriver();
    }
}
