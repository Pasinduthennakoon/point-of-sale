package com.pos.shopy.point_of_sale.repo;

import com.pos.shopy.point_of_sale.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
    List<Item> findAllByActiveStateEquals(boolean status);

    long countAllByActiveStateEquals(boolean status);

    Page<Item> findAllByActiveStateEquals(boolean state, PageRequest of);
}
