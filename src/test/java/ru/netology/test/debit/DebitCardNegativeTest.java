package ru.netology.test.debit;

import org.junit.jupiter.api.*;
import ru.netology.test.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebitCardNegativeTest extends BaseTest {

    @Test
    @DisplayName("Тест: невалидный номер карты")
    void shouldCheckTheInvalidCard() {
        var payForm = mainPage.payByDebitCard();
        var invalidCardNumber = dataHelper.getInvalidCardNumberInfo();
        payForm.fillFormAndSend(invalidCardNumber);
        payForm.checkErrorNotification();
    }

    @Test
    @DisplayName("Тест: невалидный месяц карты")
    void shouldCheckTheInvalidMonth() {
        var payForm = mainPage.payByDebitCard();
        var invalidMonth = dataHelper.getInvalidMonthInfo();
        payForm.fillForm(invalidMonth);
        payForm.checkInvalidExpirationDate();
    }

    @Test
    @DisplayName("Тест: нулевой месяц карты")
    void shouldCheckTheInvalidMonthZero() {
        var payForm = mainPage.payByDebitCard();
        var invalidMonth = dataHelper.getInvalidMonthZeroInfo();
        payForm.fillForm(invalidMonth);
        payForm.checkInvalidExpirationDate();
    }

    @Test
    @DisplayName("Тест: устаревший год карты")
    void shouldBeCheckedWithAnExpiredExpirationDate() {
        var payForm = mainPage.payByDebitCard();
        var expiredYear = dataHelper.getExpiredYearInfo();
        payForm.fillForm(expiredYear);
        payForm.checkCardExpired();
    }

    @Test
    @DisplayName("Тест: невалидный год карты")
    void shouldCheckWithTheIncorrectlySpecifiedCardExpirationDate() {
        var payForm = mainPage.payByDebitCard();
        var invalidYear = dataHelper.getInvalidYearInfo();
        payForm.fillForm(invalidYear);
        payForm.checkInvalidExpirationDate();
    }

    @Test
    @DisplayName("Тест: ввод имени владельца на русском")
    void shouldCheckTheOwnersDataInCyrillic() {
        var payForm = mainPage.payByDebitCard();
        var invalidOwner = dataHelper.getInvalidOwnerInfo();
        payForm.fillForm(invalidOwner);
        payForm.checkWrongFormat();
    }

    @Test
    @DisplayName("Тест: отправка пустой формы")
    void shouldSendAnEmptyForm() {
        var payForm = mainPage.payByDebitCard();
        var emptyFields = dataHelper.getEmptyFields();
        payForm.fillForm(emptyFields);
        payForm.checkWrongFormat();
        payForm.checkRequiredField();
    }

    @Test
    @DisplayName("Тест: ввод невалидных данных по все поля")
    void shouldBeCheckedWithInvalidDataOfAllFields() {
        var payForm = mainPage.payByDebitCard();
        var invalidValue = dataHelper.getInvalidCardForm();
        payForm.fillForm(invalidValue);
        payForm.checkInvalidMonthT();
        payForm.checkInvalidYearT();
        payForm.checkInvalidOwnerT();
        payForm.checkInvalidCVVT();
    }
}
