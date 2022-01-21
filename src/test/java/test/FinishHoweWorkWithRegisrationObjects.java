package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

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
                .typeUserNumber()
                .typeUserAddress("Krasnaya, 1-1-11")
                .setUserBirthDate("29", "July", "1990")
                .typeUserSubjects("Math")
                .selectUserHobbies()
                .uploadUserFile()
                .selectUserStateCity("NCR")
                .selectUserCity("Noida")
                .submitFillForm()
                .checkResultRegistrationForm()
                .checkResultsTable();

        registrationPage
                .checkResultsValue("Student Name", "Anna Grishina")
                .checkResultsValue("Student Email", "aaa@aa.aa")
                .checkResultsValue("Mobile", "8912345678")
                .checkResultsValue("Date of Birth", "29 July,1990")
                .checkResultsValue("Address", "Krasnaya, 1-1-11")
                .checkResultsValue("State and City", "NCR Noida");
        }

    @AfterEach
    void AfterEach() {
        closeWebDriver();
    }
}
