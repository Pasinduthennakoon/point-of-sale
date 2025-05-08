package com.pos.shopy.point_of_sale.repo;

import com.pos.shopy.point_of_sale.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
}
