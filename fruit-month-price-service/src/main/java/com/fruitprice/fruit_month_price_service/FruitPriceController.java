package com.fruitprice.fruit_month_price_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class FruitPriceController {
    @Autowired
    private Environment environment;

    @Autowired
    private FruitPriceRepository repository;

    @GetMapping("/fruit-price/fruit/{fruit}/month/{month}")
    public FruitPrice getFruitMonthPrice(@PathVariable("fruit") String fruit, @PathVariable("month") String month) {

        FruitPrice fruitPrice = repository.findByFruitAndMonth(fruit.toLowerCase(), month.toLowerCase());
        if (fruitPrice == null) {
            throw new RuntimeException("Fruit price not found for fruit: " + fruit + " and month: " + month);
        }
        int port = Integer.parseInt(environment.getProperty("local.server.port"));
        fruitPrice.setPort(port);
        return fruitPrice;
    }

    @GetMapping("/fruit-price/fruits")
    public List<String> getAllFruits() {
        return repository.findAllFruits();
    }
}

