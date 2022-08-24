package lk.ijse.apigateway.controller;

import lk.ijse.apigateway.dto.ItemDTO;
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
public class ItemController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/item")
    public List<ItemDTO> getItems() {
        ItemDTO[] forObject = restTemplate.getForObject("http://localhost:8082/api/v1/item", ItemDTO[].class);
        return Arrays.asList(forObject);
    }
}
