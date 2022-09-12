package com.m2i.crm.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.m2i.crm.model.Order;
import java.io.IOException;

/**
 *
 * @author Victor
 */
public class OrderSerializer extends StdSerializer<Order>{
    
    public OrderSerializer(){
        this(null);
    }
    
    public OrderSerializer(Class<Order> order){
        super(order);
    }

    @Override
    public void serialize(Order order, JsonGenerator jg, SerializerProvider sp) throws IOException {
        jg.writeStartObject();
            jg.writeNumberField("id", order.getId());
            jg.writeObjectFieldStart("customer");
                jg.writeNumberField("id", order.getCustomer().getId());
                jg.writeStringField("company",order.getCustomer().getCompany());
            jg.writeEndObject();
            jg.writeStringField("type",order.getType());
            jg.writeStringField("label",order.getLabel());
            jg.writeNumberField("numberOfDays",order.getNumberOfDays());
            jg.writeNumberField("unitPrice",order.getUnitPrice());
            jg.writeNumberField("totalExcludeTaxe",order.getTotalExcludeTaxe());
            jg.writeNumberField("totalWithTaxe",order.getTotalWithTaxe());
            jg.writeStringField("status",order.getStatus().toString());
            
            
        jg.writeEndObject();
    }
}
