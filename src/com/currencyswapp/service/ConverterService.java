package com.currencyswapp.service;

import com.currencyswapp.api.ExchangeRate;
import com.currencyswapp.exception.InvalidAmountException;
import com.currencyswapp.exception.UnableToGetConversionRate;
import com.currencyswapp.model.ConversionResult;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * This class handles currency conversion logic
 */
public class ConverterService {
    private final Scanner scanner = new Scanner(System.in);
    private final ExchangeRate exchangeRate = new ExchangeRate();

    /**
     * Executes a currency conversion and prints the result.
     *
     * @param base   The base currency code
     * @param target The target currency code
     * @param amount The amount to convert
     */
    public void executeConversion(String base, String target, BigDecimal amount) {
        try {
            double convertedAmount = exchangeRate.getConvertedAmount(base, target,amount.doubleValue());
            if (convertedAmount <= 0) {
                throw new UnableToGetConversionRate("Failed to retrieve a valid conversion rate");
            }
            ConversionResult result = new ConversionResult(base, target, amount, BigDecimal.valueOf(convertedAmount));
            System.out.println(result);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Handles user input for a custom conversion.
     * Prompts the user for base currency, target currency, and amount.
     */
    public void handlePersonalizeOption() {
        System.out.println("If you don't know what is the currency code " +
                "Go to https://www.exchangerate-api.com/docs/supported-currencies");

        System.out.println("Enter the base currency code: (USD, EUR, GBP, JPY)");
        String base = scanner.nextLine().toUpperCase();

        System.out.println("Enter the target currency code: (USD, EUR, GBP, JPY)");
        String target = scanner.nextLine().toUpperCase();

        System.out.println("Enter the amount: (Please note that we can only convert positive amounts)");

        try {
            BigDecimal amount = new BigDecimal(scanner.nextLine());
            if (amount.compareTo(BigDecimal.ZERO) <0) {
                throw new InvalidAmountException("Amount must be greater than zero");
            }
            executeConversion(base, target, amount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format, try again.");
        } catch (InvalidAmountException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
