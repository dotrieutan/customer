package sample.java.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.java.customer.domain.Customer;
import sample.java.customer.dto.CustomerDto;
import sample.java.customer.mapper.CustomerMapper;
import sample.java.customer.repository.CustomerRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public CustomerDto findCustomerByEmail(String email) {
        return customerMapper.customerToCustomerDto(customerRepository.findByEmail(email));
    }

    @Transactional
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        return customerMapper.customerToCustomerDto(customerRepository.save(customer));
    }

    @Transactional
    public void updateCustomer(long customerId, CustomerDto customerDto) {
        Customer customer = customerRepository.findOne(customerId);
        customerMapper.mapDtoToCustomer(customer, customerDto);
        customerRepository.save(customer);
    }
}
