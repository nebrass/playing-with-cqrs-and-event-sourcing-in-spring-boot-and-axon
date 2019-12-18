package com.targa.labs.dev.cqrses.event;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AccountCreatedEvent {

    private final UUID id;
    private final BigDecimal initialBalance;
    private final String owner;
}
