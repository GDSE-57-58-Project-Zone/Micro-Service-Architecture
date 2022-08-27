package lk.ijse.customerservice.controller;

import lk.ijse.customerservice.dto.CustomerDTO;
import lk.ijse.customerservice.service.CustomerService;
import lk.ijse.customerservice.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) {
        service.addCustomer(dto);
        return new ResponseEntity(new Response("OK",dto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateCustomer(@PathVariable String id, @RequestBody CustomerDTO dto) {
        service.updateCustomer(dto);
        return new ResponseEntity(new Response("OK",dto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable String id) {
        service.deleteCustomer(id);
        return new ResponseEntity(new Response("OK",id), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getCustomer(@PathVariable String id) {
        CustomerDTO customer = service.getCustomer(id);
        return new ResponseEntity(new Response("OK",customer), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        List<CustomerDTO> allCustomers = service.getAllCustomers();
        return new ResponseEntity(new Response("OK",allCustomers), HttpStatus.OK);
    }
}
