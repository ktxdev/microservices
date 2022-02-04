package org.ktxdev.fraud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/fraud-check")
public record FraudCheckHistoryRestController(FraudCheckHistoryService fraudCheckHistoryService) {

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable int customerId) {
        log.info("### Fraud check request for customer: {}", customerId);
        boolean fraudulent = fraudCheckHistoryService.isFraudulent(customerId);
        return new FraudCheckResponse(fraudulent);
    }
}
