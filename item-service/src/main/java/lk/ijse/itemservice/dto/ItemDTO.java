package lk.ijse.itemservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private String code;
    private String description;
    private int qtyOnHand;
    private String unitPrice;
}
