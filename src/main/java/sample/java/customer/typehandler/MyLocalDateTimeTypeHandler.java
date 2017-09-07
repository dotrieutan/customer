package sample.java.customer.typehandler;

import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import org.apache.ibatis.type.MappedTypes;

import java.time.LocalDateTime;

@MappedTypes(LocalDateTime.class)
public class MyLocalDateTimeTypeHandler extends LocalDateTimeTypeHandler {
}
