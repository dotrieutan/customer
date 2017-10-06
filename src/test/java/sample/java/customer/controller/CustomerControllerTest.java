package sample.java.customer.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sample.java.customer.dto.CustomerDto;
import sample.java.customer.dto.InputCustomerDto;
import sample.java.customer.service.CustomerService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void should_update_customer() throws Exception {

        mockMvc.perform(put("/v1/customers/1000")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\": \"first\", \"lastName\": \"last\"}"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void should_create_customer() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(1L);

        given(customerService.createCustomer(any(InputCustomerDto.class))).willReturn(customerDto);

        mockMvc.perform(post("/v1/customers/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\": \"first\", \"lastName\": \"last\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string(HttpHeaders.LOCATION, "http://localhost/v1/customers/1"));;
    }
}
