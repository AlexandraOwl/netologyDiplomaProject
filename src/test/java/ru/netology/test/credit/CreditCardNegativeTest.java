package ru.netology.test.credit;

import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.test.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardNegativeTest extends BaseTest {

    @Test
    @DisplayName("Тест: невалидный номер карты")
    void shouldCheckTheInvalidCard() {
        var payForm = mainPage.payByCreditCard();
        var invalidCardNumber = DataHelper.getInvalidCardNumberInfo();
        payForm.fillFormAndSend(invalidCardNumber);
        payForm.checkErrorNotification();
    }

    @Test
    @DisplayName("Тест: невалидный месяц")
    void shouldCheckTheInvalidMonth() {
        var payForm = mainPage.payByCreditCard();
        var invalidMonth = DataHelper.getInvalidMonthInfo();
        payForm.fillForm(invalidMonth);
        payForm.checkInvalidExpirationDate();
    }

    @Test
    @DisplayName("Тест: невалидный месяц (нулевое значение)")
    void shouldCheckTheInvalidMonthZero() {
        var payForm = mainPage.payByCreditCard();
        var invalidMonth = DataHelper.getInvalidMonthZeroInfo();
        payForm.fillForm(invalidMonth);
        payForm.checkInvalidExpirationDate();
    }

    @Test
    @DisplayName("Тест: устаревший год карты")
    void shouldBeCheckedWithAnExpiredExpirationDate() {
        var payForm = mainPage.payByCreditCard();
        var expiredYear = DataHelper.getExpiredYearInfo();
        payForm.fillForm(expiredYear);
        payForm.checkCardExpired();
    }

    @Test
    @DisplayName("Тест: невалидный год карты")
    void shouldCheckWithTheIncorrectlySpecifiedCardExpirationDate() {
        var payForm = mainPage.payByCreditCard();
        var invalidYear = DataHelper.getInvalidYearInfo();
        payForm.fillForm(invalidYear);
        payForm.checkInvalidExpirationDate();
    }

    @Test
    @DisplayName("Тест: имя владельца карты на русском языке")
    void shouldCheckTheOwnersDataInCyrillic() {
        var payForm = mainPage.payByCreditCard();
        var invalidOwner = DataHelper.getInvalidOwnerInfo();
        payForm.fillForm(invalidOwner);
        payForm.checkWrongFormat();
    }

    @Test
    @DisplayName("Тест: отправка пустой формы")
    void shouldSendAnEmptyForm() {
        var payForm = mainPage.payByCreditCard();
        var emptyFields = DataHelper.getEmptyFields();
        payForm.fillForm(emptyFields);
        payForm.checkWrongFormat();
        payForm.checkRequiredField();
    }

    @Test
    @DisplayName("Тест: ввод невалидных данных для всех полей")
    void shouldBeCheckedWithInvalidDataOfAllFields() {
        var payForm = mainPage.payByCreditCard();
        var invalidValue = DataHelper.getInvalidCardForm();
        payForm.fillForm(invalidValue);
        payForm.checkInvalidMonthT();
        payForm.checkInvalidYearT();
        payForm.checkInvalidOwnerT();
        payForm.checkInvalidCVVT();
    }
}
