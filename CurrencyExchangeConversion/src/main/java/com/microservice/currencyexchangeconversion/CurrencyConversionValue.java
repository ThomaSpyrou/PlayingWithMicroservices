package com.microservice.currencyexchangeconversion;

import java.math.BigDecimal;

public class CurrencyConversionValue {
    private long id;
    private String from;
    private String to;
    private int quantity;
    private BigDecimal conversationMultiple;
    private String environment;

    public CurrencyConversionValue(long id, String from, String to, int quantity, BigDecimal conversionMultiple, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
        this.conversationMultiple = conversionMultiple;
        this.environment = environment;
    }

    public CurrencyConversionValue() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getConversationMultiple() {
        return conversationMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversationMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
