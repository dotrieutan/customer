package sample.java.customer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sample.java.customer.dto.CustomerDto;
import sample.java.customer.service.CustomerService;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/v1/customers")
    public ResponseEntity<CustomerDto> findCustomerByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(customerService.findCustomerByEmail(email));
    }

    @PutMapping("/v1/customers/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable("customerId") int customerId,
                                               @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/v1/customers/")
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.createCustomer(customerDto);

        return ResponseEntity.noContent().build();
    }
}
