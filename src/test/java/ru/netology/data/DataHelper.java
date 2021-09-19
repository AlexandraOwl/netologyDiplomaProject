package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataHelper {

    public String getApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }

    public String getDeclinedCardNumber() {
        return "4444 4444 4444 4442";
    }

    public String getInvalidCardNumber() {
        return "0101 0101 0101  0101";
    }

    public String getEmptyCardNumberValue() {
        return " ";
    }

    public String getValidMonth() {
        return "11";
    }

    public String getInvalidMonth() {
        return "99";
    }

    public String getInvalidMonthZero() {
        return "00";
    }

    public String getEmptyMonthValue() {
        return " ";
    }

    public String getValidYear() {
        LocalDate year = LocalDate.now();
        LocalDate newYear = year.plusYears(1);
        DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yy");
        return newYear.format(yearFormatter);
    }

    public String getExpiredYear() {
        LocalDate year = LocalDate.now();
        LocalDate newYear = year.minusYears(11);
        DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yy");
        return newYear.format(yearFormatter);
    }

    public String getInvalidYear() {
        LocalDate year = LocalDate.now();
        LocalDate newYear = year.plusYears(99);
        DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yy");
        return newYear.format(yearFormatter);
    }

    public String getEmptyYearValue() {
        return " ";
    }

    public String getValidOwner() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().fullName();
    }

    public String getInvalidOwner() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    public String getEmptyOwnerValue() {
        return " ";
    }

    public String getValidCVV() {
        return "123";
    }

    public String getInvalidCVV() {
        return "12";
    }

    public String getEmptyCvvValue() {
        return " ";
    }

    public CardInfo getApprovedCardInfo() {
        return new CardInfo(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidOwner(), getValidCVV());
    }

    public CardInfo getDeclinedCardInfo() {
        return new CardInfo(getDeclinedCardNumber(), getValidMonth(), getValidYear(), getValidOwner(), getValidCVV());
    }

    public CardInfo getInvalidCardNumberInfo() {
        return new CardInfo(getInvalidCardNumber(), getValidMonth(), getValidYear(), getValidOwner(), getValidCVV());
    }

    public CardInfo getInvalidMonthInfo() {
        return new CardInfo(getApprovedCardNumber(), getInvalidMonth(), getValidYear(), getValidOwner(), getValidCVV());
    }

    public CardInfo getInvalidMonthZeroInfo() {
        return new CardInfo(getApprovedCardNumber(), getInvalidMonthZero(), getValidYear(), getValidOwner(), getValidCVV());
    }

    public CardInfo getExpiredYearInfo() {
        return new CardInfo(getApprovedCardNumber(), getValidMonth(), getExpiredYear(), getValidOwner(), getValidCVV());
    }

    public CardInfo getInvalidYearInfo() {
        return new CardInfo(getApprovedCardNumber(), getValidMonth(), getInvalidYear(), getValidOwner(), getValidCVV());
    }

    public CardInfo getInvalidOwnerInfo() {
        return new CardInfo(getApprovedCardNumber(), getValidMonth(), getValidYear(), getInvalidOwner(), getValidCVV());
    }

    public CardInfo getEmptyFields() {
        return new CardInfo(getEmptyCardNumberValue(), getEmptyMonthValue(), getEmptyYearValue(),
                getEmptyOwnerValue(), getEmptyCvvValue());
    }

    public CardInfo getInvalidValuesOfForm() {
        return new CardInfo(getInvalidCardNumber(), getInvalidMonth(), getInvalidYear(),
                getInvalidOwner(), getInvalidCVV());
    }

    public CardInfo getInvalidCardForm() {
        return new CardInfo(getInvalidCardNumber(), getInvalidMonth(), getInvalidYear(), getInvalidOwner(), getInvalidCVV());
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String month;
        String year;
        String owner;
        String cvv;
    }
}
