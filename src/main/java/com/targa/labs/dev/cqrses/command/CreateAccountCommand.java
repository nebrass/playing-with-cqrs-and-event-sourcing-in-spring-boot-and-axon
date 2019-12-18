package com.targa.labs.dev.cqrses.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountCommand {

    @TargetAggregateIdentifier
    private UUID accountId;
    private BigDecimal initialBalance;
    private String owner;
}
