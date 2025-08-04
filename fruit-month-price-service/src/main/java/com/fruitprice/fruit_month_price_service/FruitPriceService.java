package com.fruitprice.fruit_month_price_service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitPriceService {
    @Autowired
    private FruitPriceRepository repository;

    public Optional<FruitPrice> getFruitPrice(String fruit, String month) {
        return Optional.ofNullable(repository.findByFruitAndMonth(fruit.toLowerCase(), month.toLowerCase()));
    }

    public List<String> getAllFruits() {
        return repository.findAllFruits();
    }

    public List<FruitPrice> getFruitPrices(String fruit) {
        return repository.findByFruit(fruit.toLowerCase());
    }

    public FruitPrice saveFruitPrice(FruitPrice FruitPrice) {
        return repository.save(FruitPrice);
    }

    public List<FruitPrice> saveAll(List<FruitPrice> FruitPrices) {
        return repository.saveAll(FruitPrices);
    }
}
