package com.sandbox.playground1.model.ot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerOrder {
    private int orderId;
    private int customerId;
    private String status;
    private int salesmanId;
    private Date orderDate;
    private String customerName;
}
