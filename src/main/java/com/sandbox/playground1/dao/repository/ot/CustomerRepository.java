package com.sandbox.playground1.dao.repository.ot;

import com.sandbox.playground1.config.AppConfig;
import com.sandbox.playground1.dao.entity.ot.Customer;
import com.sandbox.playground1.util.mapper.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.List;

@Repository
public class CustomerRepository {

    private final JdbcTemplate otJdbcTemplate;

    private final AppConfig appConfig;

    public CustomerRepository(
            @Qualifier("ot-jdbc-template") JdbcTemplate otJdbcTemplate,
            AppConfig appConfig
            ) {
        this.otJdbcTemplate = otJdbcTemplate;
        this.appConfig = appConfig;
    }

    @Transactional(transactionManager = "ot-trx-manager")
    public void save(Customer customer) {
        otJdbcTemplate.update("INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME, ADDRESS, WEBSITE, CREDIT_LIMIT, HMM) " +
                        "VALUES (?, ?, ?, ?, ?, ?)",
                customer.getCustomerId(),
                customer.getName(),
                customer.getAddress(),
                customer.getWebsite(),
                customer.getCreditLimit(),
                customer.getHmm());
    }

    @Transactional(transactionManager = "ot-trx-manager")
    public void saveAll(List<Customer> customers) {
        otJdbcTemplate.batchUpdate("INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME, ADDRESS, WEBSITE, CREDIT_LIMIT, HMM) " +
                        "VALUES (?, ?, ?, ?, ?, ?)",
                customers,
                appConfig.getBatchSize(),
                (PreparedStatement ps, Customer customer) -> {
                    ps.setInt(1, customer.getCustomerId());
                    ps.setString(2, customer.getName());
                    ps.setString(3, customer.getAddress());
                    ps.setString(4, customer.getWebsite());
                    ps.setBigDecimal(5, customer.getCreditLimit());
                    ps.setString(6, customer.getHmm());
                }
        );
    }

    public List<Customer> findAll() {
        return otJdbcTemplate.query("SELECT * FROM CUSTOMERS", new CustomerRowMapper());
    }

    public List<Customer> findByNameAndId(String name, int id) {
        return otJdbcTemplate.query("SELECT * FROM CUSTOMERS WHERE NAME = ? AND CUSTOMER_ID = ?", new CustomerRowMapper(), name, id);
    }

    public List<Customer> findByNameLike(String name) {
        return otJdbcTemplate.query("SELECT * FROM CUSTOMERS WHERE NAME LIKE ?", new CustomerRowMapper(), "%" + name + "%");
    }

    public List<Customer> findByCreditLimitIn(List<BigDecimal> creditLimits) {
        return otJdbcTemplate.query(
                String.format(
                        "SELECT * FROM CUSTOMERS WHERE CREDIT_LIMIT IN (%s)",
                        String.join(",", Collections.nCopies(creditLimits.size(), "?"))),
                new CustomerRowMapper(),
                creditLimits.toArray()
        );
    }
}
