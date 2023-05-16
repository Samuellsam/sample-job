package com.sandbox.playground1.util.mapper;

import com.sandbox.playground1.model.ot.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Customer.builder()
                .customerId(rs.getInt("CUSTOMER_ID"))
                .name(rs.getString("NAME"))
                .address(rs.getString("ADDRESS"))
                .website(rs.getString("WEBSITE"))
                .creditLimit(rs.getBigDecimal("CREDIT_LIMIT"))
                .hmm(rs.getString("HMM"))
                .build();
    }
}
