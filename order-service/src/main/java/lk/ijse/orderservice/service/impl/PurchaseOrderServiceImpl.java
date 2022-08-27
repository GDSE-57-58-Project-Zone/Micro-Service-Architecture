package lk.ijse.orderservice.service.impl;

import lk.ijse.orderservice.dto.OrderDTO;
import lk.ijse.orderservice.dto.OrderDetailsDTO;
import lk.ijse.orderservice.entity.Orders;
import lk.ijse.orderservice.exception.ValidationException;
import lk.ijse.orderservice.repo.OrdersRepo;
import lk.ijse.orderservice.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RestTemplate http;

    @Override
    public void addOrder(OrderDTO dto) {
        //in here we can do business validation using other micro services
        //01. check customer before placing order
        http.getForEntity("http://customer-service/api/v1/customer/" + dto.getCustomerID(), String.class);

        //02 check items are available or not
        for (OrderDetailsDTO orderDetail : dto.getOrderDetails()) {
            http.getForEntity("http://item-service/api/v1/item/"+orderDetail.getOrder_details_fk().getItemCode(), String.class);
        }

        //03. check order id duplicated or not
        if (repo.existsById(dto.getOid())) throw new ValidationException("Order id duplicated..!");

        //04. if all ok place order
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
        if (!repo.existsById(id)) throw new ValidationException("No Order for ID : "+id);
        return mapper.map(repo.getById(id), OrderDTO.class);
    }

    @Override
    public void deleteOrder(String id) {
        if (!repo.existsById(id)) throw new ValidationException("Cannot Delete No Order for ID : "+id);
        repo.deleteById(id);
    }

    @Override
    public void updateOrder(OrderDTO dto) {
        if (!repo.existsById(dto.getOid())) throw new ValidationException("Cannot Update Order for ID : "+dto.getOid());
        repo.save(mapper.map(dto, Orders.class));
    }
}
