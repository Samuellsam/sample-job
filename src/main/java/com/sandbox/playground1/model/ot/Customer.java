package com.sandbox.playground1.model.ot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private int customerId;
    private String name;
    private String address;
    private String website;
    private BigDecimal creditLimit;
    private String hmm;
}
