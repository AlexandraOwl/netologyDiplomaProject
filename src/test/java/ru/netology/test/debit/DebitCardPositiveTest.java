package ru.netology.test.debit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
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
        var approvedInfo = DataHelper.getApprovedCardInfo();
        payForm.fillFormAndSend(approvedInfo);
        payForm.checkOperationIsApproved();
        String dataSQLPayment = SQLHelper.getPaymentStatus();
        assertEquals("APPROVED", dataSQLPayment);
    }

    @Test
    @DisplayName("Тест: проверка покупки в базе данных")
    void shouldBeCheckedWithValidData() {
        var payForm = mainPage.payByDebitCard();
        var approvedInfo = DataHelper.getApprovedCardInfo();
        payForm.fillFormAndSend(approvedInfo);
        payForm.checkOperationIsApproved();
        String dataSQLPayAmount = SQLHelper.getPaymentAmount();
        assertEquals("45000", dataSQLPayAmount);
    }

    @Test
    @DisplayName("Тест: проверка declined дебетовой карты с валидными данными")
    void shouldCheckTheDeclinedCardAndTheValidData() {
        var payForm = mainPage.payByDebitCard();
        var declinedInfo = DataHelper.getDeclinedCardInfo();
        payForm.fillFormAndSend(declinedInfo);
        payForm.checkErrorNotification();
        String dataSQLPayment = SQLHelper.getPaymentStatus();
        assertEquals("DECLINED", dataSQLPayment);
    }
}
