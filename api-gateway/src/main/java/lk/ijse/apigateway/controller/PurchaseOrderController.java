package lk.ijse.apigateway.controller;

import lk.ijse.apigateway.dto.CustomerDTO;
import lk.ijse.apigateway.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/v1/consume")
public class PurchaseOrderController {

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping(path = "/order")
    public List<OrderDTO> getOrders() {
        OrderDTO[] forObject = restTemplate.getForObject("http://order-service/api/v1/order", OrderDTO[].class);
        return Arrays.asList(forObject);
    }




}
