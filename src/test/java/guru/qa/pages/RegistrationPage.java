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
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderFemale = $(byText("Female")),
            userNumberInput = $("#userNumber"),
            userSubjectsInput = $("#subjectsInput"),
            userHobbies = $("#hobbiesWrapper").$(byText("Sports")),
            userFile = $("#uploadPicture"),
            userAddressInput = $("#currentAddress"),
            userStateCity = $("#stateCity-wrapper").$(byText("NCR")),
            userCity = $("#stateCity-wrapper").$(byText("Noida")),
            submit = $("#submit"),
            resultRegistrationForm = $("[class*=modal-content]"),
            resultsTable = $(".table-responsive"),
            resultFormText = $(byText("Thanks for submitting the form"));

    public CalendarComponents calendarComponents = new CalendarComponents();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage selectUserGender() {
        userGenderFemale.click();
        return this;
    }

    public RegistrationPage typeUserNumber() {
        userNumberInput.setValue("8912345678");
        return this;
    }

    public RegistrationPage setUserBirthDate(String day, String month, String year){
        calendarComponents.setDate(day, month, year);
        return this;
    }

    public RegistrationPage typeUserSubjects(String value){
        userSubjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage selectUserHobbies(){
        userHobbies.click();
        return this;
    }
    public RegistrationPage uploadUserFile(){
        File file = new File("src/test/resources/1.png");
        userFile.uploadFile(file);
        return this;
    }

    public RegistrationPage typeUserAddress(String value){
        userAddressInput.setValue(value).click();
        return this;
    }
    public RegistrationPage selectUserStateCity(String value) {
        userStateCity.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage selectUserCity(String value) {
        userCity.setValue(value).pressEnter();
        return this;
        }

    public RegistrationPage submitFillForm(){
        submit.scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage checkResultRegistrationForm(){
        resultRegistrationForm.should(visible);
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value){
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkResultsTable(){
        resultFormText.should(appear);
        return this;
    }
 }


