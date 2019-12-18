package com.targa.labs.dev.cqrses.event;

import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class MoneyCreditedEvent {

    private final UUID id;
    private final BigDecimal creditAmount;
}
