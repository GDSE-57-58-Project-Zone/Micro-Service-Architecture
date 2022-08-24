package lk.ijse.orderservice.repo;

import lk.ijse.orderservice.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, String> {
}
