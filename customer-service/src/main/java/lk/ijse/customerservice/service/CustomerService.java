package lk.ijse.customerservice.service;

import lk.ijse.customerservice.dto.CustomerDTO;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface CustomerService {
    void addCustomer(CustomerDTO dto);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomer(String id);

    void deleteCustomer(String id);

    void updateCustomer(CustomerDTO dto);
}
