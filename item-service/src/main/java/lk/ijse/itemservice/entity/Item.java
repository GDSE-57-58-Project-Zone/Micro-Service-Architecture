package lk.ijse.itemservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    private String code;
    private String description;
    private int qtyOnHand;
    private String unitPrice;


}
