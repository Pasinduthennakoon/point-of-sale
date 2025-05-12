package com.pos.shopy.point_of_sale.repo;

import com.pos.shopy.point_of_sale.entity.Order;
import com.pos.shopy.point_of_sale.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {
}
