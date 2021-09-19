package ru.netology.test.debit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.test.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebitCardPositiveTest extends BaseTest {

    @Test
    @DisplayName("Тест: загрузка страницы покупки с дебетовой карты")
    void shouldCheckTheDownloadOfThePaymentByCard() {
        mainPage.payByDebitCard();
    }

    @Test
    @DisplayName("Тест: проверка дебетовой approved карты с валидными данными")
    void shouldCheckWithAnApprovedCardAndValidData() {
        var payForm = mainPage.payByDebitCard();
        var approvedInfo = dataHelper.getApprovedCardInfo();
        payForm.fillFormAndSend(approvedInfo);
        payForm.checkOperationIsApproved();
        String dataSQLPayment = sqlHelper.getPaymentStatus();
        assertEquals("APPROVED", dataSQLPayment);
    }

    @Test
    @DisplayName("Тест: проверка покупки в базе данных")
    void shouldBeCheckedWithValidData() {
        var payForm = mainPage.payByDebitCard();
        var approvedInfo = dataHelper.getApprovedCardInfo();
        payForm.fillFormAndSend(approvedInfo);
        payForm.checkOperationIsApproved();
        String dataSQLPayAmount = sqlHelper.getPaymentAmount();
        assertEquals("45000", dataSQLPayAmount);
    }

    @Test
    @DisplayName("Тест: проверка declined дебетовой карты с валидными данными")
    void shouldCheckTheDeclinedCardAndTheValidData() {
        var payForm = mainPage.payByDebitCard();
        var declinedInfo = dataHelper.getDeclinedCardInfo();
        payForm.fillFormAndSend(declinedInfo);
        payForm.checkErrorNotification();
        String dataSQLPayment = sqlHelper.getPaymentStatus();
        assertEquals("DECLINED", dataSQLPayment);
    }
}
