package com.currency.microservicescurrex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class CurrencyExchange {
    @Id
    private long id;
    @Column(name = "curr_from")
    private String from;
    @Column(name = "curr_to")
    private String to;
    private BigDecimal conversationMultiple;
    private String environment;

    public CurrencyExchange(long id, String from, String to, BigDecimal conversationMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversationMultiple = conversationMultiple;
    }

    public CurrencyExchange() {}

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

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

    public BigDecimal getConversationMultiple() {
        return conversationMultiple;
    }

    public void setConversationMultiple(BigDecimal conversationMultiple) {
        this.conversationMultiple = conversationMultiple;
    }
}
