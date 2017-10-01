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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sample.java.customer.dto.CustomerDto;
import sample.java.customer.dto.InputCustomerDto;
import sample.java.customer.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/v1/customers/search")
    public ResponseEntity<CustomerDto> searchCustomer(@RequestParam("email") String email) {
        return ResponseEntity.ok(customerService.findCustomerByEmail(email));
    }

    @PutMapping("/v1/customers/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable("customerId") int customerId,
                                               @RequestBody InputCustomerDto inputCustomerDto) {
        customerService.updateCustomer(customerId, inputCustomerDto);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/v1/customers/")
    public ResponseEntity<Void> createCustomer(@RequestBody InputCustomerDto inputCustomerDto,
                                               HttpServletRequest request) {
        CustomerDto customerDto = customerService.createCustomer(inputCustomerDto);

        URI location = ServletUriComponentsBuilder.fromContextPath(request)
                .path("/v1/customers/{id}")
                .buildAndExpand(customerDto.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
