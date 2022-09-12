package com.m2i.crm.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.m2i.crm.model.Order;
import com.m2i.crm.service.IOrderService;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin(origins = "http://localhost:4200") //CrossOrigin permet de gérer les problèmes de Cors, l'URL indiquée est celle du front
@RequestMapping("/orders")
public class OrderController {
    
    private final IOrderService  orderService;
    private Order orderToDelete;
    
    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    // listAll [GET] -> orders/
    @GetMapping("")
    @ApiOperation(value="get all orders", response= Order.class )
    public ResponseEntity<Object> getOrders() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    // create [POST] -> orders/
    @RequestMapping(method=RequestMethod.POST)
    @ApiOperation(value="add one order", response= Order.class )
    public ResponseEntity<Object> createOrder(@RequestBody Order order) {
        this.orderService.create(order);
        return new ResponseEntity<>(orderService.findById(order.getId()) , HttpStatus.CREATED);
    }

    // update [PUT] -> orders/{id}
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @ApiOperation(value="modify one order", response= Order.class )
    public ResponseEntity<Object> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        try {
            this.orderService.update(order, id);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("Order with id " + id + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(orderService.findById(id) , HttpStatus.OK);
    }

    // getById [GET] -> orders/{id}
    @GetMapping("/{id}")
    @ApiOperation(value="get one order by ID", response= Order.class )
    public ResponseEntity<Object> getOrderById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }
    
    // delete [DELETE] -> orders/{id}
     @RequestMapping(value ="/{id}", method =RequestMethod.DELETE)
     @ApiOperation(value="delete one order by ID", response= Order.class )
     public ResponseEntity<Object>deleteOrder(@PathVariable("id") Long id){
         orderToDelete=orderService.delete(id);
         return new ResponseEntity<>(orderToDelete, HttpStatus.OK);
     }
}
