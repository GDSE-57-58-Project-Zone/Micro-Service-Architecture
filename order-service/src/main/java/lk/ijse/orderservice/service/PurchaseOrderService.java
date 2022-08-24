package lk.ijse.orderservice.service;

import lk.ijse.orderservice.dto.OrderDTO;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface PurchaseOrderService {
     void addOrder(OrderDTO dto);
     List<OrderDTO> getAllOrders();
     OrderDTO getOrder(String id);
     void deleteOrder(String id);
     void updateOrder(OrderDTO dto);
}
