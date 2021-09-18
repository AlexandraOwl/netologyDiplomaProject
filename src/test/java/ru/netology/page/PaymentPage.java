package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    private final SelenideElement cardNumberField = $("[placeholder = '0000 0000 0000 0000']");
    private final SelenideElement monthField = $("[placeholder = '08']");
    private final SelenideElement yearField = $("[placeholder = '22']");
    private final SelenideElement ownerField = $$("[class='input__control']").get(3);
    private final SelenideElement cvvField = $("[placeholder='999']");
    private final SelenideElement buttonForContinue = $(byText("Продолжить"));
    private final SelenideElement sendRequestBankButton = $(withText("Отправляем запрос в Банк..."));

    private final SelenideElement operationIsApproved = $(withText("Операция одобрена Банком"));
    private final SelenideElement errorNotification = $(withText("Ошибка! Банк отказал в проведении операции."));
    private final SelenideElement invalidExpirationDate = $(withText("Неверно указан срок действия карты"));
    private final SelenideElement cardExpired = $(withText("Истёк срок действия карты"));
    private final SelenideElement wrongFormat = $(".input__sub");
    private final SelenideElement requiredField = $(withText("Поле обязательно для заполнения"));

    public void fillFormAndSend(DataHelper.CardInfo cardInfo) {
        this.fillForm(cardInfo);
        sendRequestBankButton.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void fillForm(DataHelper.CardInfo cardInfo) {
        cardNumberField.setValue(cardInfo.getCardNumber());
        monthField.setValue(cardInfo.getMonth());
        yearField.setValue(cardInfo.getYear());
        ownerField.setValue(cardInfo.getOwner());
        cvvField.setValue(cardInfo.getCvv());
        buttonForContinue.click();
    }

    public void checkOperationIsApproved() {
        operationIsApproved.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void checkErrorNotification() {
        errorNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void checkInvalidExpirationDate() {
        invalidExpirationDate.shouldBe(Condition.visible);
    }

    public void checkCardExpired() {
        cardExpired.shouldBe(Condition.visible);
    }

    public void checkWrongFormat() {
        wrongFormat.shouldHave(text("Неверный формат"));
    }

    public void checkRequiredField() {
        requiredField.shouldBe(Condition.visible);
    }

    public void checkInvalidCardNumberT(DataHelper.CardInfo invalidValue) {
        cardNumberField.$("input__sub").shouldHave(text("Неверный формат"));
    }

    public void checkInvalidMonthT() {
        monthField.$("input__sub").shouldHave(text("Неверный формат"));
    }

    public void checkInvalidYearT() {
        yearField.$("input__sub").shouldHave(text("Неверный формат"));
    }

    public void checkInvalidOwnerT() {
        ownerField.$("input__sub").shouldHave(text("Неверный формат"));
    }

    public void checkInvalidCVVT() {
        cvvField.$("input__sub").shouldHave(text("Неверный формат"));
    }
}
