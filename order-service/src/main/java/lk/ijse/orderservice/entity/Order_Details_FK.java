package lk.ijse.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_Details_FK implements Serializable {
    private String oid;
    private String itemCode;
}
