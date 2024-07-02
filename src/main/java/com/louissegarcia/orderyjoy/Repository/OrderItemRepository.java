package com.louissegarcia.orderyjoy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louissegarcia.orderyjoy.Model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
