package lk.ijse.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    @EmbeddedId
    Order_Details_FK order_details_fk;
    private int qty;
    private double unitPrice;
    @ManyToOne
    @JoinColumn(name = "oid",referencedColumnName = "oid",insertable = false,updatable = false)
    private Orders orders;

}
