package com.tsb.vn.customer.mapper;

import com.tsb.vn.customer.dto.dataitem.CustomerDataItem;
import com.tsb.vn.customer.dto.param.CustomerParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper {

    CustomerDataItem findByEmail(@Param("customer") CustomerParam customerParam);

    void updateCustomer(@Param("customer") CustomerParam customerParam);
}
