package com.pos.shopy.point_of_sale.repo;

import com.pos.shopy.point_of_sale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByCustomerNameEquals(String name);

    List<Customer> findAllByActiveStateEquals(boolean b);

}
