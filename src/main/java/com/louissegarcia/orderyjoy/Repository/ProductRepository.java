package com.louissegarcia.orderyjoy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louissegarcia.orderyjoy.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
