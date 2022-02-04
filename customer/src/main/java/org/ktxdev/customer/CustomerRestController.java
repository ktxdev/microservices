package org.ktxdev.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerRestController(
        CustomerService customerService
) {
    @PostMapping
    public void register(@RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("New Customer registration: {}", customerRequest);
        customerService.register(customerRequest);
    }
}
