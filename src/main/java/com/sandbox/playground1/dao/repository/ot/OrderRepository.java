package com.sandbox.playground1.dao.repository.ot;

import com.sandbox.playground1.model.CustomerOrder;
import com.sandbox.playground1.util.mapper.CustomerOrderRowMapper;
import com.sandbox.playground1.util.mapper.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    private final JdbcTemplate otJdbcTemplate;

    public OrderRepository(@Qualifier("ot-jdbc-template") JdbcTemplate otJdbcTemplate) {
        this.otJdbcTemplate = otJdbcTemplate;
    }

    public List<CustomerOrder> findAllOrderByCustomerId(int customerId) {
        return otJdbcTemplate.query(
                "SELECT\n" +
                        "  O.ORDER_ID,\n" +
                        "  C.CUSTOMER_ID,\n" +
                        "  O.STATUS,\n" +
                        "  O.SALESMAN_ID,\n" +
                        "  O.ORDER_DATE,\n" +
                        "  C.NAME AS CUSTOMER_NAME\n" +
                        "FROM \n" +
                        "  CUSTOMERS C\n" +
                        "JOIN ORDERS O\n" +
                        "  ON C.CUSTOMER_ID = O.CUSTOMER_ID\n" +
                        "WHERE\n" +
                        "  C.CUSTOMER_ID = ?",
                new CustomerOrderRowMapper(),
                customerId
        );
    }
}
