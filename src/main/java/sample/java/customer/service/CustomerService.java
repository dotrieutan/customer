package sample.java.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.java.customer.dto.CustomerDto;
import sample.java.customer.mapper.CustomerMapper;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;

    public CustomerDto findCustomerByEmail(String email) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setEmail(email);
        return customerMapper.findByEmail(customerDto);
    }

    @Transactional
    public void updateCustomer(long customerId, CustomerDto customerDto) {
        customerDto.setId(customerId);
        customerMapper.updateCustomer(customerDto);
    }
}
