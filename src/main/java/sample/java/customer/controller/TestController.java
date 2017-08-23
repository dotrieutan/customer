package com.tsb.vn.customer.controller;

import com.tsb.vn.customer.dto.dataitem.CustomerDataItem;
import com.tsb.vn.customer.dto.param.CustomerParam;
import com.tsb.vn.customer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/v1/customers")
    public ResponseEntity<CustomerDataItem> findCustomer(@RequestParam("email") String email) {
        return ResponseEntity.ok(testService.findCustomerByEmail(email));
    }

    @PutMapping("/v1/customers/{customerId}")
    public ResponseEntity<Void> updateTest(@PathVariable("customerId") int customerId,
                                           @RequestBody CustomerParam customerParam) {
        testService.updateCustomer(customerId, customerParam);

        return ResponseEntity.noContent().build();
    }
}
