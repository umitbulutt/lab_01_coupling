package com.cydeo.tightly;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CustomerBalance {

    private UUID userId;
    private BigDecimal amount;

    public CustomerBalance(UUID userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public void addBalance(BigDecimal amount) {
        setAmount(this.amount.add(amount));
    }
}
