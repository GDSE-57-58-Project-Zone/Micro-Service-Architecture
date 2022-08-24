package lk.ijse.itemservice.repo;

import lk.ijse.itemservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface ItemRepo extends JpaRepository<Item,String> {
}
