package org.ktxdev.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public record FraudCheckHistoryService(FraudCheckHistoryRepository repository) {

    public boolean isFraudulent(int customerId) {
        repository.save(FraudCheckHistory.builder()
                .isFraudster(false)
                .customerId(customerId)
                .createdAt(LocalDate.now())
                .build());
        return false;
    }
}
