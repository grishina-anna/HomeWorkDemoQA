package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class FinishHoweWorkWithRegisrationObjects extends TestBase {

    @Test
    void fillFormTest() {
        registrationPage
                .openPage()
                .typeFirstName("Anna")
                .typeLastName("Grishina")
                .typeUserEmail("aaa@aa.aa")
                .selectUserGender()
                .typeUserNumber();

        registrationPage.calendar.setDate("29", "July", "1990");

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

        registrationPage
                .checkResultsvalue("Student Name", "Anna Grishina")
                .checkResultsvalue("Student Email", "aaa@aa.aa")
                .checkResultsvalue("Mobile", "8912345678")
                .checkResultsvalue("Date of Birth", "29 July,1990")
                .checkResultsvalue("Address", "Krasnaya, 1-1-11")
                .checkResultsvalue("State and City", "NCR Noida");
    }

    @AfterEach
    void AfterEach() {
        closeWebDriver();
    }
}
