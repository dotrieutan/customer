package sample.java.customer.typehandler;

import org.apache.ibatis.type.LocalDateTypeHandler;
import org.apache.ibatis.type.MappedTypes;

import java.time.LocalDate;

@MappedTypes(LocalDate.class)
public class MyLocalDateTypeHandler extends LocalDateTypeHandler {
}
