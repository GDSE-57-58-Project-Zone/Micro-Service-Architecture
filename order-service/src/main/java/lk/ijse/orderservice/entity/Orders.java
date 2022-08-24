package lk.ijse.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    private String oid;
    private String date;
    private String customerID;
    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;


}
