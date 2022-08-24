package lk.ijse.itemservice.controller;

import lk.ijse.itemservice.dto.ItemDTO;
import lk.ijse.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping
    public ResponseEntity saveItem(@RequestBody ItemDTO dto) {
        service.addItem(dto);
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateItem(@PathVariable String id, @RequestBody ItemDTO dto) {
        service.updateItem(dto);
        return new ResponseEntity(dto, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteItem(@PathVariable String id) {
        service.deleteItem(id);
        return new ResponseEntity("Done", HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getItem(@PathVariable String id) {
        ItemDTO Item = service.getItem(id);
        return new ResponseEntity(Item, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllItems() {
        List<ItemDTO> allItems = service.getAllItems();
        return new ResponseEntity(allItems, HttpStatus.OK);
    }
}
