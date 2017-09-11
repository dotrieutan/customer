package sample.java.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import sample.java.customer.domain.Customer;
import sample.java.customer.dto.CustomerDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);

    void mapDtoToCustomer(@MappingTarget Customer customer, CustomerDto customerDto);
}
