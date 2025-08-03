package com.fruitprice.fruit_total_price_service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FruitTotalController {

    @Value("${fruit.month.service.url}") // fetches the URL from env variable FRUIT_MONTH_SERVICE_URL
    private String fruitMonthServiceUrl;

    @GetMapping("/fruit-total/fruit/{fruit}/month/{month}/quantity/{quantity}")
    public FruitTotal retrieveFruitPrice(@PathVariable String fruit, @PathVariable String month,
            @PathVariable int quantity) {
        HashMap<String,String> uriVariables = new HashMap<>();
        uriVariables.put("fruit", fruit);
        uriVariables.put("month", month);
        
        ResponseEntity<FruitTotal> responseEntity = new RestTemplate().getForEntity(
                fruitMonthServiceUrl + "/fruit-price/fruit/{fruit}/month/{month}", FruitTotal.class, uriVariables);
        FruitTotal fruitTotal = responseEntity.getBody();

        if (fruitTotal == null) {
            throw new RuntimeException("Unable to find fruit price for " + fruit + " in month " + month);
        }
        return new FruitTotal(fruitTotal.getId(), fruit, month, fruitTotal.getFmp(), quantity,
                fruitTotal.getFmp() * quantity, fruitTotal.getPort());
    }
}
