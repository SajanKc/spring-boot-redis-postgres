package com.iamsajan.springbootredispostgres.repository;

import com.iamsajan.springbootredispostgres.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
