package com.sandbox.playground1;

import com.sandbox.playground1.service.ot.CustomerService;
import com.sandbox.playground1.service.ot.OrderService;
import com.sandbox.playground1.service.ychord.MstChordService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Playground1Application {

    CustomerService customerService;

    MstChordService mstChordService;

    OrderService orderService;

    public Playground1Application(
            CustomerService customerService,
            MstChordService mstChordService,
            OrderService orderService
    ) {
        this.customerService = customerService;
        this.mstChordService = mstChordService;
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Playground1Application.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @PostConstruct
    void start() {
//        # BATCH INSERT EXAMPLE
//        customerService.saveAll(new ArrayList<Customer>() {{
//            add(
//                    Customer.builder()
//                            .customerId(-10)
//                            .name("A")
//                            .address("ADDRESS A")
//                            .website("WEBSITE A")
//                            .creditLimit(new BigDecimal("21.02"))
//                            .build()
//            );
//            add(
//                    Customer.builder()
//                            .customerId(-9)
//                            .name("A")
//                            .address("ADDRESS A")
//                            .website("WEBSITE A")
//                            .creditLimit(new BigDecimal("21.02"))
//                            .hmm("GG")
//                            .build()
//            );
//        }});
//
//        mstChordService.saveAll(new ArrayList<MstChord>() {{
//            add(
//                    MstChord.builder()
//                            .chordId(UuidUtil.generateRandomOracleUuid())
//                            .name("Cadd9")
//                            .build()
//            );
//            add(
//                    MstChord.builder()
//                            .chordId("1")
//                            .name("Gsus7")
//                            .build()
//            );
//        }});

//        # FIND ALL EX
//        List<Customer> customers = customerService.findAll();
//
//        for (Customer customer : customers) {
//            System.out.println(customer.getCustomerId());
//            System.out.println(customer.getName());
//            System.out.println(customer.getAddress());
//            System.out.println(customer.getWebsite());
//            System.out.println(customer.getCreditLimit().add(new BigDecimal("102.354")));
//            System.out.println(customer.getHmm());
//            System.out.println("-------------------------------");
//        }

//        # INSERT ONE
//        customerService.save(
//                Customer.builder()
//                        .customerId(-21)
//                        .name("A")
//                        .address("ADDRESS A")
//                        .website("WEBSITE A")
//                        .creditLimit(new BigDecimal("23.1779"))
//                        .hmm("HMM")
//                        .build()
//        );

//        # FIND WITH FILTER
//        List<Customer> customers = customerService.findByNameAndId("A", -21);
//
//        for (Customer customer : customers) {
//            System.out.println(customer.getCustomerId());
//            System.out.println(customer.getName());
//            System.out.println(customer.getAddress());
//            System.out.println(customer.getWebsite());
//            System.out.println(customer.getCreditLimit());
//            System.out.println(customer.getHmm());
//            System.out.println("-------------------------------");
//        }

//        # FIND BY FILTER LIKE
//        List<Customer> customers = customerService.findByNameLike("A");
//
//        System.out.println(customers.size());
//
//        for (Customer customer : customers) {
//            System.out.println(customer.getCustomerId());
//            System.out.println(customer.getName());
//            System.out.println(customer.getAddress());
//            System.out.println(customer.getWebsite());
//            System.out.println(customer.getCreditLimit());
//            System.out.println(customer.getHmm());
//            System.out.println("-------------------------------");
//        }

//        # FIND BY IN
//        List<Customer> customers = customerService.findByCreditLimitIn(
//                new ArrayList<BigDecimal>() {{
//                    add(new BigDecimal("200"));
//                    add(new BigDecimal("100"));
//                    add(new BigDecimal("500"));
//                }}
//        );
//
//        System.out.println(customers.size());
//
//        for (Customer customer : customers) {
//            System.out.println(customer.getCustomerId());
//            System.out.println(customer.getName());
//            System.out.println(customer.getAddress());
//            System.out.println(customer.getWebsite());
//            System.out.println(customer.getCreditLimit());
//            System.out.println(customer.getHmm());
//            System.out.println("-------------------------------");
//        }

//        # FIND WITH JOIN
//        List<CustomerOrder> orders = orderService.findAllOrderByCustomerId(1);
//
//        for (CustomerOrder order : orders) {
//            System.out.println(order.getOrderId());
//            System.out.println(order.getCustomerId());
//            System.out.println(order.getStatus());
//            System.out.println(order.getSalesmanId());
//            System.out.println(order.getOrderDate());
//            System.out.println(order.getCustomerName());
//            System.out.println("-------------------------------");
//        }
    }
}
