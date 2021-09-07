package ru.netology.test.credit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.test.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardPositiveTest extends BaseTest {

    @Test
    @DisplayName("Тест: загрузка страницы покупки в кредит")
    void shouldCheckTheDownloadOfThePaymentByCard() {
        mainPage.payByCreditCard();
    }

    @Test
    @DisplayName("Тест: валидные данные для Approved кредитной карты")
    void shouldCheckWithAnApprovedCardAndValidData() {
        var payForm = mainPage.payByCreditCard();
        var approvedInfo = DataHelper.getApprovedCardInfo();
        payForm.fillFormAndSend(approvedInfo);
        payForm.checkOperationIsApproved();
        String dataSQLPayment = SQLHelper.getPaymentStatus();
        assertEquals("APPROVED", dataSQLPayment);
    }

    @Test
    @DisplayName("Тест: проверка покупки в базе данных")
    void shouldBeCheckedWithValidData() {
        var payForm = mainPage.payByCreditCard();
        var approvedInfo = DataHelper.getApprovedCardInfo();
        payForm.fillFormAndSend(approvedInfo);
        payForm.checkOperationIsApproved();
        String dataSQLPayAmount = SQLHelper.getPaymentAmount();
        assertEquals("45000", dataSQLPayAmount);
    }

    @Test
    @DisplayName("Тест: валидные данные для Declined карты")
    void shouldCheckTheDeclinedCardAndTheValidData() {
        var payForm = mainPage.payByCreditCard();
        var declinedInfo = DataHelper.getDeclinedCardInfo();
        payForm.fillFormAndSend(declinedInfo);
        payForm.checkErrorNotification();
        String dataSQLPayment = SQLHelper.getPaymentStatus();
        assertEquals("DECLINED", dataSQLPayment);
    }
}
