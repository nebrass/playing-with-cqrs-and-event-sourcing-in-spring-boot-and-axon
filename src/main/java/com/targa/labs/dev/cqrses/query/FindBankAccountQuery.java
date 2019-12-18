package com.targa.labs.dev.cqrses.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindBankAccountQuery {
    private UUID accountId;
}
