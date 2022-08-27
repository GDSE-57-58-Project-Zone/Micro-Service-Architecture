package lk.ijse.customerservice.service.impl;

import lk.ijse.customerservice.dto.CustomerDTO;
import lk.ijse.customerservice.entity.Customer;
import lk.ijse.customerservice.exception.ValidationException;
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
        if (!repo.existsById(dto.getId())) throw new ValidationException("Customer already exist..!");
        repo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapper.map(repo.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        if (!repo.existsById(id)) throw new ValidationException("No customer for :" + id);
        return mapper.map(repo.getById(id), CustomerDTO.class);
    }

    @Override
    public void deleteCustomer(String id) {
        if (!repo.existsById(id)) throw new ValidationException("Cannot Delete,No customer for :" + id);
        repo.deleteById(id);
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getId()))
            throw new ValidationException("Cannot Update,No customer for :" + dto.getId());
        repo.save(mapper.map(dto, Customer.class));
    }
}
