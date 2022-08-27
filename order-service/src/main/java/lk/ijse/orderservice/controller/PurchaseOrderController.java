package lk.ijse.orderservice.controller;

import lk.ijse.orderservice.dto.OrderDTO;
import lk.ijse.orderservice.service.PurchaseOrderService;
import lk.ijse.orderservice.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/v1/order")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService service;

    @PostMapping
    public ResponseEntity saveOrder(@RequestBody OrderDTO dto) {
        service.addOrder(dto);
        return new ResponseEntity(new Response("OK",dto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateOrder(@PathVariable String id, @RequestBody OrderDTO dto) {
        service.updateOrder(dto);
        return new ResponseEntity(new Response("OK",dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteOrder(@PathVariable String id) {
        service.deleteOrder(id);
        return new ResponseEntity(new Response("OK",id), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getOrder(@PathVariable String id) {
        OrderDTO order = service.getOrder(id);
        return new ResponseEntity(new Response("OK",order), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllOrders() {
        List<OrderDTO> allOrders = service.getAllOrders();
        return new ResponseEntity(new Response("OK",allOrders), HttpStatus.OK);
    }
}
