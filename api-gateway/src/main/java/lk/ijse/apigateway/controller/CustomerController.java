package lk.ijse.apigateway.controller;

import lk.ijse.apigateway.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/v1/consume")
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/customer")
    public ResponseEntity getAllCustomers() {
        CustomerDTO[] forObject = restTemplate.getForObject("http://localhost:8081/api/v1/customer", CustomerDTO[].class);
        return new ResponseEntity(Arrays.asList(forObject), HttpStatus.OK);
    }

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO dto) {
        ResponseEntity<CustomerDTO> customerDTOResponseEntity = restTemplate.postForEntity("http://localhost:8081/api/v1/customer", dto, CustomerDTO.class);
        return customerDTOResponseEntity.getBody();
    }


}
