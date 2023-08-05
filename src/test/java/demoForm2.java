import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class demoForm2 {

    @BeforeAll
    static void beforeAll() {
        com.codeborne.selenide.Configuration.baseUrl = "https://demoqa.com";
        com.codeborne.selenide.Configuration.browserSize = "1920x1080";
        com.codeborne.selenide.Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanovivan@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("8911018552");
        $("#dateOfBirthInput").click();
        $(By.className("react-datepicker__year-select")).click();
        $(By.className("react-datepicker__year-select")).selectOptionContainingText("1990");
        $(By.className("react-datepicker__month-select")).click();
        $(By.className("react-datepicker__month-select")).selectOption(3);
        $(byText("1")).click();
        $("#subjectsInput").setValue("E");
        $("#react-select-2-option-0").click();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/recources/test.png"));
        $("#currentAddress").setValue("Saint Petersburg, Russia");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(byText("Student Name")).shouldHave(text("Student Name"));
        $(byText("Ivan Ivanov")).shouldHave(text("Ivan Ivanov"));
        $(byText("Student Email")).shouldHave(text("Student Email"));
        $(byText("Ivanovivan@gmail.com")).shouldHave(text("Ivanovivan@gmail.com"));
        $(byText("Gender")).shouldHave(text("Gender"));
        $(byText("Male")).shouldHave(text("Male"));
        $(byText("Mobile")).shouldHave(text("Mobile"));
        $(byText("8911018552")).shouldHave(text("8911018552"));
        $(byText("Date of Birth")).shouldHave(text("Date of Birth"));
        $(byText("01 April,1990")).shouldHave(text("01 April,1990"));
        $(byText("Subjects")).shouldHave(text("Subjects"));
        $(byText("English")).shouldHave(text("English"));
        $(byText("Hobbies")).shouldHave(text("Hobbies"));
        $(byText("Sports")).shouldHave(text("Sports"));
        $(byText("Picture")).shouldHave(text("Picture"));
        $(byText("test.png")).shouldHave(text("test.png"));
        $(byText("Address")).shouldHave(text("Address"));
        $(byText("Saint Petersburg, Russia")).shouldHave(text("Saint Petersburg, Russia"));
        $(byText("State and City")).shouldHave(text("State and City"));
        $(byText("NCR Delhi")).shouldHave(text("NCR Delhi"));
    }
}