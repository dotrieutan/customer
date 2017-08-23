package sample.java.customer.mapper;

import sample.java.customer.dto.dataitem.CustomerDataItem;
import sample.java.customer.dto.param.CustomerParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper {

    CustomerDataItem findByEmail(@Param("customer") CustomerParam customerParam);

    void updateCustomer(@Param("customer") CustomerParam customerParam);
}
