package thaovan.lab8.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thaovan.lab8.entity.OrdersEntity;
import thaovan.lab8.service.OrdersService;

@RestController
@RequestMapping("/api/order")
public class OrderRest {

    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public ResponseEntity order(@RequestBody OrdersEntity ordersEntity) {
        OrdersEntity order = this.ordersService.save(ordersEntity);
        return ResponseEntity.ok(order);
    }
}
