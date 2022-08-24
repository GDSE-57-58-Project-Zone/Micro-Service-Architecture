package lk.ijse.customerservice.service.impl;

import lk.ijse.customerservice.dto.CustomerDTO;
import lk.ijse.customerservice.entity.Customer;
import lk.ijse.customerservice.repo.CustomerRepo;
import lk.ijse.customerservice.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO dto) {
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapper.map(repo.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        Customer customer = repo.getById(id);
        return mapper.map(customer, CustomerDTO.class);
    }

    @Override
    public void deleteCustomer(String id) {
        repo.deleteById(id);
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        repo.save(mapper.map(dto, Customer.class));
    }
}
