package lk.ijse.customerservice.repo;

import lk.ijse.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface CustomerRepo extends JpaRepository<Customer, String> {
}
