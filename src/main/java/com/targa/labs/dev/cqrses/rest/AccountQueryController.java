package com.targa.labs.dev.cqrses.rest;

import com.targa.labs.dev.cqrses.entity.BankAccount;
import com.targa.labs.dev.cqrses.service.AccountQueryService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/accounts")
@Api(value = "Bank Account Queries", description = "Bank Account Query Events API")
@AllArgsConstructor
public class AccountQueryController {

    private final AccountQueryService accountQueryService;

    @GetMapping("/{accountId}")
    public CompletableFuture<BankAccount> findById(@PathVariable("accountId") String accountId) {
        return this.accountQueryService.findById(accountId);
    }

    @GetMapping("/{accountId}/events")
    public List<Object> listEventsForAccount(@PathVariable(value = "accountId") String accountId) {
        return this.accountQueryService.listEventsForAccount(accountId);
    }
}
