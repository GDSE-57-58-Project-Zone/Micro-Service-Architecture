package lk.ijse.apigateway.controller;

import lk.ijse.apigateway.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        OrderDTO[] forObject = restTemplate.getForObject("http://localhost:8083/api/v1/order", OrderDTO[].class);
        return Arrays.asList(forObject);
    }


}
