package sample.java.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import sample.java.customer.domain.Customer;
import sample.java.customer.dto.CustomerDto;
import sample.java.customer.dto.InputCustomerDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    void mapDtoToCustomer(@MappingTarget Customer customer, InputCustomerDto inputCustomerDto);

    Customer inputCustomerDtoToCustomer(InputCustomerDto inputCustomerDto);
}
