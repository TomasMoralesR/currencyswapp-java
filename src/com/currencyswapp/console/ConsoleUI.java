package com.currencyswapp.console;

import com.currencyswapp.service.ConverterService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final ConverterService converterService = new ConverterService();

    public void start() {
        while (true) {
            printMenu();
            int option = getUserOption();
            if (option == 8) {
                System.out.println("Thanks for using CurrencySwapp!");
                break;
            }
            processOption(option);
        }
    }

    private void printMenu() {
        System.out.println("""
                $->€->¥->£->元->₩->₹->₽->₺->฿->₱->$->€->¥->£->元->₩->₹->₽
                
                $  Hey, what kind of Swapp would you like to do today?  $
                1. USD -> ARS
                2. ARS -> USD
                3. USD -> COP
                4. COP -> USD
                5. USD -> BRL
                6. BRL -> USD
                7. Custom Swapp
                8. Exit""");
    }

    private int getUserOption() {
        System.out.println("Select a valid option:");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Try again.");
            return -1;
        }
    }

    private void processOption(int option) {
        switch (option) {
            case 1 -> converterService.executeConversion("USD", "ARS", BigDecimal.ONE);
            case 2 -> converterService.executeConversion("ARS", "USD", BigDecimal.ONE);
            case 3 -> converterService.executeConversion("USD", "COP", BigDecimal.ONE);
            case 4 -> converterService.executeConversion("COP", "USD", BigDecimal.ONE);
            case 5 -> converterService.executeConversion("USD", "BRL", BigDecimal.ONE);
            case 6 -> converterService.executeConversion("BRL", "USD", BigDecimal.ONE);
            case 7 -> converterService.handlePersonalizeOption();
            default -> System.out.println("Not a valid option, try again.");
        }
    }
    }
