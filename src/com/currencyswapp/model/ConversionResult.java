package com.currencyswapp.model;

import java.math.BigDecimal;

public record ConversionResult(String base, String target, BigDecimal amount, BigDecimal convertedAmount) {
    @Override
    public String toString() {
        return String.format("Conversion: %.2f %s to %s -> %.4f",
                amount, base, target, convertedAmount);
    }
}
