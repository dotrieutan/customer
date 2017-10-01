package sample.java.customer.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InputCustomerDto {

    String email;

    String firstName;

    String lastName;
}
