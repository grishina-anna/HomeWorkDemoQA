package test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FinishHoweWithRandomWithFakerWorkTest extends TestBase {

    Faker faker = new Faker(new Locale("ru"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String streetAdress = faker.address().streetAddress();
    String userNumber = faker.number().digits(10);

     @Test
     void fillFormTest() {
         open("/automation-practice-form");
         $("#firstName").setValue(firstName);
         $("#lastName").setValue(lastName);
         $("#userEmail").setValue(email);
         $("[for='gender-radio-1']").click();
         $("#userNumber").setValue(userNumber);
         $("#dateOfBirthInput").click();
         $(".react-datepicker__month-select").click();
         $(".react-datepicker__month-select").selectOption("July");
         $(".react-datepicker__year-select").selectOption("1990");
         $(byText("29")).click();
         $("#subjectsInput").setValue("Math").pressEnter();
         $("[for*='hobbies-checkbox-2']").click();
         File file = new File("src/test/resources/1.png");
         $("#uploadPicture").uploadFile(file);
         $("#currentAddress").setValue(streetAdress);
         $("#state").scrollTo().click();
         $("#stateCity-wrapper").$(byText("NCR")).click();
         $("#city").click();
         $("#stateCity-wrapper").$(byText("Noida")).click();
         $("#submit").scrollIntoView(true).click();

         $("[class*=modal-content]").should(visible);
         $(byText("Thanks for submitting the form")).should(appear);
         $(".table-responsive").shouldHave(
                 text(firstName),
                 text(lastName),
                 text(email),
                 text(userNumber),
                 text("29 July,1990"),
                 text(streetAdress));
     }

    @AfterEach
    void AfterEach() {
        closeWebDriver();
    }
}
