package lk.ijse.itemservice.service.impl;

import lk.ijse.itemservice.dto.ItemDTO;
import lk.ijse.itemservice.entity.Item;
import lk.ijse.itemservice.repo.ItemRepo;
import lk.ijse.itemservice.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addItem(ItemDTO dto) {
        repo.save(mapper.map(dto, Item.class));
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapper.map(repo.findAll(), new TypeToken<List<ItemDTO>>() {
        }.getType());
    }

    @Override
    public ItemDTO getItem(String id) {
        Item Item = repo.getById(id);
        return mapper.map(Item, ItemDTO.class);
    }

    @Override
    public void deleteItem(String id) {
        repo.deleteById(id);
    }

    @Override
    public void updateItem(ItemDTO dto) {
        repo.save(mapper.map(dto, Item.class));
    }
}
