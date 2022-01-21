package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class FinishHoweWorkWithRegisrationObjectsTest extends TestBase {

    @Test
    void fillFormTest() {
        registrationPage
                .openPage()
                .typeFirstName("Anna")
                .typeLastName("Grishina")
                .typeUserEmail("aaa@aa.aa")
                .selectUserGender("Female")
                .typeUserNumber("1234345343")
                .setUserBirthDate("29", "July", "1990")
                .typeUserSubjects("Maths")
                .selectUserHobbies("Sports")
                .uploadUserFile("src/test/resources/1.png")
                .typeUserAddress("Krasnaya, 1-1-11")
                .scrollTo()
                .selectUserStateCity("NCR")
                .cityFillForm()
                .selectUserCity("Noida")
                .submitFillForm()
                .checkResultRegistrationForm()
                .checkResultsTable();

        registrationPage
                .checkResultsValue("Student Name", "Anna Grishina")
                .checkResultsValue("Student Email", "aaa@aa.aa")
                .checkResultsValue("Mobile", "1234345343")
                .checkResultsValue("Date of Birth", "29 July,1990")
                .checkResultsValue("Address", "Krasnaya, 1-1-11")
                .checkResultsValue("State and City", "NCR Noida");
        }

    @AfterEach
    void AfterEach() {
        closeWebDriver();
    }
}
