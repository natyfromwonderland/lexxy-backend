package com.example.pupilservice.proxy;

import com.example.pupilservice.dto.UpdateItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@FeignClient("SHOP-SERVICE")
public interface ShopServiceProxy {

    @GetMapping("/app/shop")
    List<UpdateItemDTO> getAllTeachers();

    @GetMapping("/app/shop/{id}")
    UpdateItemDTO getById(@PathVariable("id") Long id);

    @PostMapping("/app/shop")
    UpdateItemDTO createNewShopItem(@RequestBody UpdateItemDTO updateItemDTO);
}
