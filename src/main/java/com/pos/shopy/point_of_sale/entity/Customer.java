package com.pos.shopy.point_of_sale.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @Column(name = "customer_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO) //genarate id on auto
    private int customerId;

    @Column(name = "customer_name",length = 100,nullable = false)
    private String customerName;

    @Column(name = "customer_address",length = 150)
    private String customerAddress;

    @Column(name = "customer_salary",length = 25)
    private double customerSalary;

    @Type(JsonType.class)
    @Column(name = "contact_numbers", columnDefinition = "json")
    private List<String> contactNumbers;


    @Column(name = "nic",length = 12,unique = true)
    private String nic;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy="customer")
    private Set<Order> orders;

    //new constructor using id is not pass in frontend
    public Customer(String customerName, String customerAddress, double customerSalary, List<String> contactNumbers, String nic, boolean activeState) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
        this.activeState = activeState;
    }

}
