package sample.java.customer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sample.java.customer.dto.CustomerDto;

@Mapper
public interface CustomerMapper {

    CustomerDto findByEmail(@Param("customer") CustomerDto customerDto);

    void updateCustomer(@Param("customer") CustomerDto customerDto);
}
