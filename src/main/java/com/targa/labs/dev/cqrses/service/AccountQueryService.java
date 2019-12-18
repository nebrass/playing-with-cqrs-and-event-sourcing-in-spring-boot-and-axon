package com.targa.labs.dev.cqrses.service;

import com.targa.labs.dev.cqrses.entity.BankAccount;
import com.targa.labs.dev.cqrses.query.FindBankAccountQuery;
import lombok.AllArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.targa.labs.dev.cqrses.service.ServiceUtils.formatUuid;

@Service
@AllArgsConstructor
public class AccountQueryService {
    private final QueryGateway queryGateway;
    private final EventStore eventStore;

    public CompletableFuture<BankAccount> findById(String accountId) {
        return this.queryGateway.query(
                new FindBankAccountQuery(formatUuid(accountId)),
                ResponseTypes.instanceOf(BankAccount.class)
        );
    }

    public List<Object> listEventsForAccount(String accountId) {
        return this.eventStore
                .readEvents(formatUuid(accountId).toString())
                .asStream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
    }
}
