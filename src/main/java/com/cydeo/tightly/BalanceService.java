package com.cydeo.tightly;

import java.math.BigDecimal;

public class BalanceService {

    CustomerBalance customerBalance;
    GiftCardBalance giftCardBalance;

    public BalanceService(CustomerBalance customerBalance, GiftCardBalance giftCardBalance) {
        this.customerBalance = customerBalance;
        this.giftCardBalance = giftCardBalance;
    }

    public boolean checkoutFromCustomerBalance(BigDecimal checkoutAmount) {

        BigDecimal customerBalanceAmount = this.customerBalance.getAmount();

        if (customerBalanceAmount.subtract(checkoutAmount).compareTo(BigDecimal.ZERO) >= 0) {
            this.customerBalance.setAmount(customerBalanceAmount.subtract(checkoutAmount));
            return true;
        }

        return false;
    }

    public boolean checkoutFromGiftCardBalance(BigDecimal checkoutAmount) {

        BigDecimal giftCardBalanceAmount = this.giftCardBalance.getAmount();

        if (giftCardBalanceAmount.subtract(checkoutAmount).compareTo(BigDecimal.ZERO) >= 0) {
            this.giftCardBalance.setAmount(giftCardBalanceAmount.subtract(checkoutAmount));
            return true;
        }

        return false;
    }
}
