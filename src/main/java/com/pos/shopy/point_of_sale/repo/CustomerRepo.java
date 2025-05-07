package com.pos.shopy.point_of_sale.repo;

import com.pos.shopy.point_of_sale.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
@Transactional
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByCustomerNameEquals(String name);

    List<Customer> findAllByActiveStateEquals(boolean b);

    @Modifying
    @Query(value = "update customer set customer_name =?1 , nic =?2 where  customer_id =?3", nativeQuery = true)
    void updateCustomerByQuary(String customerName, String nic, int id);

}
