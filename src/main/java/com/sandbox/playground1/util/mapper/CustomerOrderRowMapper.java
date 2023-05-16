package com.sandbox.playground1.util.mapper;

import com.sandbox.playground1.model.CustomerOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerOrderRowMapper implements RowMapper<CustomerOrder> {
    @Override
    public CustomerOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CustomerOrder.builder()
                .orderId(rs.getInt("ORDER_ID"))
                .customerId(rs.getInt("CUSTOMER_ID"))
                .status(rs.getString("STATUS"))
                .salesmanId(rs.getInt("SALESMAN_ID"))
                .orderDate(rs.getDate("ORDER_DATE"))
                .customerName(rs.getString("CUSTOMER_NAME"))
                .build();
    }
}
