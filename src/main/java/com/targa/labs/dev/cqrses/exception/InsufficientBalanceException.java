package com.targa.labs.dev.cqrses.exception;

import java.math.BigDecimal;
import java.util.UUID;

public class InsufficientBalanceException extends Throwable {
    public InsufficientBalanceException(UUID accountId, BigDecimal debitAmount) {
        super("Insufficient Balance: Cannot debit " + debitAmount +
                " from account number [" + accountId.toString() + "]");
    }
}
