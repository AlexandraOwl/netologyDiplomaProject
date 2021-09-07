package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class MainPage {
    private final SelenideElement buyButton = $(byText("Купить"));
    private final SelenideElement creditButton = $(byText("Купить в кредит"));
    private final SelenideElement paymentDebit = $(byText("Оплата по карте"));
    private final SelenideElement paymentCredit = $(byText("Кредит по данным карты"));

    public PaymentPage payByDebitCard() {
        buyButton.click();
        paymentDebit.shouldHave(Condition.visible);
        return new PaymentPage();
    }

    public PaymentPage payByCreditCard() {
        creditButton.click();
        paymentCredit.shouldHave(Condition.visible);
        return new PaymentPage();
    }
}
