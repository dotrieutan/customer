package com.tsb.vn.customer.typehandler;

import org.apache.ibatis.type.MappedTypes;

import java.time.LocalDate;

@MappedTypes(LocalDate.class)
public class LocalDateTypeHandler extends org.apache.ibatis.type.LocalDateTypeHandler {
}
