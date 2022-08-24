package lk.ijse.orderservice.service.impl;

import lk.ijse.orderservice.dto.OrderDTO;
import lk.ijse.orderservice.entity.Orders;
import lk.ijse.orderservice.repo.OrdersRepo;
import lk.ijse.orderservice.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private OrdersRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addOrder(OrderDTO dto) {
        Orders map = mapper.map(dto, Orders.class);
        repo.save(map);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return mapper.map(repo.findAll(), new TypeToken<List<OrderDTO>>() {
        }.getType());
    }

    @Override
    public OrderDTO getOrder(String id) {
        Orders Orders = repo.getById(id);
        return mapper.map(Orders, OrderDTO.class);
    }

    @Override
    public void deleteOrder(String id) {
        repo.deleteById(id);
    }

    @Override
    public void updateOrder(OrderDTO dto) {
        repo.save(mapper.map(dto, Orders.class));
    }
}
