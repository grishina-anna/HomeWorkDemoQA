package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //локаторы и элементы
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            EmailInput = $("#Email"),
            genterWrapperInput = $("Female"),
            resultTable = $(".table-responsive");
    public CalendarComponents calendar = new CalendarComponents();

    //дейстdвия
    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text("FORM_TITLE"));
    }
//        public void typeFirstName(String value) { //если void. то мы не ждем ответа, поэтому меняем на RegistrationPage
    public RegistrationPage typeFirstName(String value) { // после этого, можно удалить registrationPage. на странице с тестом
        firstNameInput.setValue(value);
        return this; //вернуть объект класса
    }
    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
            }
    public RegistrationPage typeEmail (String value) {
        EmailInput.setValue(value);
        return this;
    }
    public RegistrationPage typeGenterWrapper (String value) {
        genterWrapperInput.setValue(value).click();
        return this;
    }
//    public RegistrationPage userEmail(String value) {
//        userEmailInput.setValue(value);
//        return this;
//    }
//    public RegistrationPage userEmail(String value) {
//        userEmailInput.setValue(value);
//        return this;
//    }
//    public RegistrationPage userEmail(String value) {
//        userEmailInput.setValue(value);
//        return this;
//    }
//    public RegistrationPage userEmail(String value) {
//        userEmailInput.setValue(value);
//        return this;
//    }

    public RegistrationPage checkResultsvalue(String key, String value ) {
        resultTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}


