package lk.ijse.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_Details_FK_DTO implements Serializable {
    private String oid;
    private String itemCode;
}
