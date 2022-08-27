package lk.ijse.itemservice.service.impl;

import lk.ijse.itemservice.dto.ItemDTO;
import lk.ijse.itemservice.entity.Item;
import lk.ijse.itemservice.exception.ValidationException;
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
        if ( !repo.existsById(dto.getCode())) throw  new ValidationException("Item already exist..!");
        repo.save(mapper.map(dto, Item.class));
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapper.map(repo.findAll(), new TypeToken<List<ItemDTO>>() {
        }.getType());
    }

    @Override
    public ItemDTO getItem(String id) {
        if ( !repo.existsById(id))  throw new ValidationException("No Item for :"+id);
        return mapper.map(repo.getById(id), ItemDTO.class);
    }

    @Override
    public void deleteItem(String id) {
        if ( !repo.existsById(id)) throw  new ValidationException("Cannot Delete,No Item for :"+id);
        repo.deleteById(id);
    }

    @Override
    public void updateItem(ItemDTO dto) {
        if ( !repo.existsById(dto.getCode())) throw  new ValidationException("Cannot Update,No Item for :"+dto.getCode());
        repo.save(mapper.map(dto, Item.class));
    }
}
