package com.fruitprice.fruit_total_price_service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DecStringSerializer extends JsonSerializer<Double> {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @Override
    public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            BigDecimal rounded = BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
            gen.writeString(df.format(rounded));
        } else {
            gen.writeNull();
        }
    }

}
