package lk.ijse.itemservice.service;

import lk.ijse.itemservice.dto.ItemDTO;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface ItemService {
     void addItem(ItemDTO dto);
     List<ItemDTO> getAllItems();
     ItemDTO getItem(String id);
     void deleteItem(String id);
     void updateItem(ItemDTO dto);
}
