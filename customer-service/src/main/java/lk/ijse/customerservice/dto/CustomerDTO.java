package lk.ijse.customerservice.dto;

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
public class CustomerDTO {
    private String id;
    private String name;
    private String address;
    private String salary;
}
