package sample.java.customer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.java.customer.dto.CustomerDto;
import sample.java.customer.service.CustomerService;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/v1/customers")
    public ResponseEntity<CustomerDto> findCustomer(@RequestParam("email") String email) {
        return ResponseEntity.ok(customerService.findCustomerByEmail(email));
    }

    @PutMapping("/v1/customers/{customerId}")
    public ResponseEntity<Void> updateTest(@PathVariable("customerId") int customerId,
                                           @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);

        return ResponseEntity.noContent().build();
    }
}
