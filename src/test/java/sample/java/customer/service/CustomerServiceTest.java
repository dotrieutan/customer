package sample.java.customer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import sample.java.customer.domain.Customer;
import sample.java.customer.dto.CustomerDto;
import sample.java.customer.dto.InputCustomerDto;
import sample.java.customer.mapper.CustomerMapper;
import sample.java.customer.mapper.CustomerMapperImpl;
import sample.java.customer.repository.CustomerRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Spy
    private CustomerMapper customerMapper = new CustomerMapperImpl();

    @Test
    public void should_create_customer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setEmail("test@test.com");
        customer.setFirstName("first");
        customer.setLastName("last");

        given(customerRepository.save(any(Customer.class))).willReturn(customer);

        CustomerDto customerDto = customerService.createCustomer(new InputCustomerDto());

        assertThat(customerDto)
                .isNotNull()
                .extracting("id", "firstName", "lastName", "email")
                .containsExactly(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }

    @Test
    public void should_update_customer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setEmail("test@test.com");
        customer.setFirstName("first");
        customer.setLastName("last");

        given(customerRepository.findOne(1L)).willReturn(customer);

        customerService.updateCustomer(1L, new InputCustomerDto());

        verify(customerRepository).save(any(Customer.class));
    }
}
