package com.tsb.vn.customer.typehandler;

import org.apache.ibatis.type.MappedTypes;

import java.time.LocalDateTime;

@MappedTypes(LocalDateTime.class)
public class LocalDateTimeTypeHandler extends org.apache.ibatis.type.LocalDateTimeTypeHandler {
}
