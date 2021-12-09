package com.example.shopservice.controller;

import com.example.shopservice.dto.UpdateItemDTO;
import com.example.shopservice.service.UpdateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/app/shop")
@CrossOrigin(origins = "*")
public class UpdateItemController {

    @Autowired
    UpdateItemService updateItemService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UpdateItemDTO> getAllItems() { return updateItemService.getAllShopItems(); }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateItemDTO getById(@PathVariable("id") Long id) throws ParseException {
        return updateItemService.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UpdateItemDTO createNewShopItem(@RequestBody UpdateItemDTO updateItemDTO) throws ParseException {
        return updateItemService.createNewShopItem(updateItemDTO);
    }
}
