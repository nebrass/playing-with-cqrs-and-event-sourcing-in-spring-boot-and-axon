package com.targa.labs.dev.cqrses.service;

import com.targa.labs.dev.cqrses.command.CreateAccountCommand;
import com.targa.labs.dev.cqrses.command.CreditMoneyCommand;
import com.targa.labs.dev.cqrses.command.DebitMoneyCommand;
import com.targa.labs.dev.cqrses.entity.BankAccount;
import com.targa.labs.dev.cqrses.rest.dto.AccountCreationDTO;
import com.targa.labs.dev.cqrses.rest.dto.MoneyAmountDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static com.targa.labs.dev.cqrses.service.ServiceUtils.formatUuid;

@Service
@AllArgsConstructor
public class AccountCommandService {
    private final CommandGateway commandGateway;

    public CompletableFuture<BankAccount> createAccount(AccountCreationDTO creationDTO) {
        return this.commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID(),
                creationDTO.getInitialBalance(),
                creationDTO.getOwner()
        ));
    }

    public CompletableFuture<String> creditMoneyToAccount(String accountId,
                                                          MoneyAmountDTO moneyCreditDTO) {
        return this.commandGateway.send(new CreditMoneyCommand(
                formatUuid(accountId),
                moneyCreditDTO.getAmount()
        ));
    }

    public CompletableFuture<String> debitMoneyFromAccount(String accountId,
                                                           MoneyAmountDTO moneyDebitDTO) {
        return this.commandGateway.send(new DebitMoneyCommand(
                formatUuid(accountId),
                moneyDebitDTO.getAmount()
        ));
    }
}
