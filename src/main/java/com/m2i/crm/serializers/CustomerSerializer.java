package com.m2i.crm.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.m2i.crm.model.Customer;
import com.m2i.crm.model.Order;
import java.io.IOException;

/**
 *
 * @author Victor
 */
public class CustomerSerializer extends StdSerializer<Customer> {

    public CustomerSerializer(){
        this(null);
    }
    
    public CustomerSerializer(Class<Customer> customer){
        super(customer);
    }
    
    @Override
    public void serialize(Customer customer, JsonGenerator jg, SerializerProvider sp) throws IOException {
       jg.writeStartObject();
       jg.writeNumberField("id", customer.getId());
       jg.writeStringField("firstName", customer.getFirstName());
       jg.writeStringField("lastName", customer.getLastName());
       jg.writeStringField("company", customer.getCompany());
       jg.writeStringField("mail", customer.getMail());
       jg.writeStringField("phone", customer.getPhone());
       jg.writeStringField("address", customer.getAddress() );
       jg.writeStringField("zipCode", customer.getZipCode());
       jg.writeStringField("city", customer.getCity());
       jg.writeStringField("country", customer.getCountry());
       jg.writeStringField("active", customer.getActive().toString());
       jg.writeArrayFieldStart("orders");
       for(Order order:customer.getOrders()){
           jg.writeStartObject();
            jg.writeNumberField("id", order.getId());
            jg.writeStringField("type",order.getType());
            jg.writeStringField("label",order.getLabel());
            jg.writeNumberField("numberOfDays",order.getNumberOfDays());
            jg.writeNumberField("unitPrice",order.getUnitPrice());
            jg.writeNumberField("totalExcludeTaxe",order.getTotalExcludeTaxe());
            jg.writeNumberField("totalWithTaxe",order.getTotalWithTaxe());
            jg.writeStringField("status",order.getStatus().toString());
           jg.writeEndObject();
       } 
       jg.writeEndArray();
       jg.writeEndObject();
    }
    
}
