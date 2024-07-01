package com.louissegarcia.orderyjoy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louissegarcia.orderyjoy.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
