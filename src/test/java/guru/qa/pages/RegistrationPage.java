package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.CalendarComponents;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final String FORM_TITLE = "Student Registration Form";

    public CalendarComponents calendarComponents = new CalendarComponents();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationPage selectUserGender(String gender) {
        $("[for='gender-radio-1']").click();
        return this;
    }

    public RegistrationPage typeUserNumber(String phoneNumber) {
        $("#userNumber").setValue(phoneNumber);
        return this;
    }

    public RegistrationPage setUserBirthDate(String day, String month, String year){
        calendarComponents.setDate(day, month, year);
        return this;
    }

    public RegistrationPage typeUserSubjects(String value){
        $("#subjectsInput").setValue("Math").pressEnter();
        return this;
    }

    public RegistrationPage selectUserHobbies(String value){
        $("[for*='hobbies-checkbox-2']").click();
        return this;
    }

    public RegistrationPage uploadUserFile(String value){
        File file = new File("src/test/resources/1.png");
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    public RegistrationPage typeUserAddress(String value){
        $("#currentAddress").setValue(value);
        return this;
    }
    public RegistrationPage scrollTo(){
        $("#state").scrollTo().click();
        return this;
    }

    public RegistrationPage selectUserStateCity(String value) {
        $("#stateCity-wrapper").$(byText("NCR")).click();
        return this;
    }

    public RegistrationPage cityFillForm(){
        $("#city").click();
        return this;
    }

    public RegistrationPage selectUserCity(String value) {
        $("#stateCity-wrapper").$(byText("Noida")).click();
        return this;
        }

    public RegistrationPage submitFillForm(){
        $("#submit").scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage checkResultRegistrationForm(){
        $("[class*=modal-content]").should(visible);
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkResultsTable(){
        $(byText("Thanks for submitting the form")).should(appear);
        return this;
    }
 }


