package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
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
            UserNumberInput = $("#userNumber"),
            resultTable = $(".table-responsive");

    public CalendarComponents calendar = new CalendarComponents();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    //        public void typeFirstName(String value) { //если void. то мы не ждем ответа, поэтому меняем на RegistrationPage
    public RegistrationPage typeFirstName(String value) { // после этого, можно удалить registrationPage. на странице с тестом
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
        UserNumberInput.setValue("8912345678");
        return this;
    }


    public RegistrationPage checkResultsvalue(String key, String value) {
        resultTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}


