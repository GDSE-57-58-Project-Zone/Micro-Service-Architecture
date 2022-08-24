package lk.ijse.customerservice.entity;

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
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
    private String salary;


}
