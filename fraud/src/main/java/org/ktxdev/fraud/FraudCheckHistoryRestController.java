package org.ktxdev.fraud;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
public record FraudCheckHistoryRestController(FraudCheckHistoryService fraudCheckHistoryService) {

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudstar(@PathVariable int customerId) {
        boolean fraudulent = fraudCheckHistoryService.isFraudulent(customerId);
        return new FraudCheckResponse(fraudulent);
    }
}
