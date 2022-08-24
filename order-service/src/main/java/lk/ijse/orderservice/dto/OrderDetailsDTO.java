package lk.ijse.orderservice.dto;

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
public class OrderDetailsDTO {
    private Order_Details_FK_DTO order_details_fk;
    private int qty;
    private double unitPrice;
}
