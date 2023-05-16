package com.sandbox.playground1.service.ot;

import com.sandbox.playground1.model.ot.Customer;
import com.sandbox.playground1.repository.ot.CustomerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void saveAll(List<Customer> customers) {
        customerRepository.saveAll(customers);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findByNameAndId(String name, int id) {
        return customerRepository.findByNameAndId(name, id);
    }

    public List<Customer> findByNameLike(String name) {
        return customerRepository.findByNameLike(name);
    }

    public List<Customer> findByCreditLimitIn(List<BigDecimal> creditLimits) {
        return customerRepository.findByCreditLimitIn(creditLimits);
    }
}
