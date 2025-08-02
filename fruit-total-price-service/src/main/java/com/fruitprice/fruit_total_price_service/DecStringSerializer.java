package com.fruitprice.fruit_total_price_service;

import java.io.IOException;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DecStringSerializer extends JsonSerializer<Double> {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @Override
    public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            gen.writeString(df.format(value));
        }
        else {
            gen.writeNull();
        }
    }


}
