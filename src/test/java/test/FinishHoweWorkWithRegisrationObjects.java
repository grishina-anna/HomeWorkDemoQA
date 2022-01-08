package test;

import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FinishHoweWorkWithRegisrationObjects extends TestBase {

    @Test
    void fillFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName("Anna").
                typeLastName("Grishina").
                typeEmail("aaa@aa.aa").
                typeGenterWrapper("Female");
        $("#userNumber").setValue("8912345678");
        registrationPage.calendar.setDate("29","July","1990");
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
                .checkResultsvalue ("Email","aaa@aa.aa")
                .checkResultsvalue ("#genterWrapper","Female")
                .checkResultsvalue ("#userNumber","8912345678")
                .checkResultsvalue ("#dateOfBirthInput","29 July,1990")
                .checkResultsvalue ("#subjectsInput","Math")
                .checkResultsvalue ("#hobbiesWrapper","Sports")
                .checkResultsvalue ("#uploadPicture","img/1.png")
                .checkResultsvalue ("#currentAddress","Krasnaya, 1-1-11")
                .checkResultsvalue ("#stateCity-wrapper","NCR Noida");
    }

    @AfterEach
    void AfterEach() {
        closeWebDriver();
    }
}
