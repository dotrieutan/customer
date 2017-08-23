package com.tsb.vn.customer.service;

import com.tsb.vn.customer.dto.dataitem.CustomerDataItem;
import com.tsb.vn.customer.dto.param.CustomerParam;
import com.tsb.vn.customer.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TestService {

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerDataItem findCustomerByEmail(String email) {
        CustomerParam customerParam = new CustomerParam();
        customerParam.setEmail(email);
        return customerMapper.findByEmail(customerParam);
    }

    @Transactional
    public void updateCustomer(long customerId, CustomerParam customerParam) {
        customerParam.setId(customerId);
        customerMapper.updateCustomer(customerParam);
    }
}
