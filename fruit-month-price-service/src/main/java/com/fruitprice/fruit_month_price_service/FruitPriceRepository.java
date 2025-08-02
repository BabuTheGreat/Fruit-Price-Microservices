package com.fruitprice.fruit_month_price_service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FruitPriceRepository extends JpaRepository<FruitPrice, Long> {
    FruitPrice findByFruitAndMonth(String fruit, String month);

    @Query("SELECT DISTINCT f.fruit FROM FruitPrice f ORDER BY f.fruit")
    List<String> findAllFruits();

    List<FruitPrice> findByFruit(String fruit);



}
