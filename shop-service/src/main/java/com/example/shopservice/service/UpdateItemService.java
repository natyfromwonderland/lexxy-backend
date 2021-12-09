package com.example.shopservice.service;

import com.example.shopservice.dao.AvatarUpdateItem;
import com.example.shopservice.dto.UpdateItemDTO;
import com.example.shopservice.repository.UpdateItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UpdateItemService {

    private final UpdateItemRepository updateItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UpdateItemService(UpdateItemRepository updateItemRepository) {
        this.updateItemRepository = updateItemRepository;
    }

    public List<UpdateItemDTO> getAllShopItems() {
        List<AvatarUpdateItem> items = updateItemRepository.findAll();
        return items.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public UpdateItemDTO getById(Long id) {
        Optional<AvatarUpdateItem> item = updateItemRepository.findById(id);
        if (item.isPresent()) {
            return convertToDto(item.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no Item with id " + id);
        }
    }

    public UpdateItemDTO createNewShopItem(UpdateItemDTO updateItemDTO) throws ParseException {

        if (updateItemRepository.findById(updateItemDTO.getId()).isPresent()) {
            return convertToDto(updateItemRepository.findById(updateItemDTO.getId()).get());
        } else {
            AvatarUpdateItem newItem = convertToEntity(updateItemDTO);
            newItem = updateItemRepository.save(newItem);

            return convertToDto(updateItemRepository.findById(newItem.getId()).get());
        }
    }

    public AvatarUpdateItem dtoToDao(UpdateItemDTO updateItemDTO) throws ParseException {
        return convertToEntity(updateItemDTO);
    }

    public AvatarUpdateItem convertToEntity(UpdateItemDTO updateItemDTO) throws ParseException {
        AvatarUpdateItem item = modelMapper.map(updateItemDTO, AvatarUpdateItem.class);
        return item;
    }

    public UpdateItemDTO convertToDto(AvatarUpdateItem avatarUpdateItem) {
        UpdateItemDTO updateItemDTO = modelMapper.map(avatarUpdateItem, UpdateItemDTO.class);
        return updateItemDTO;
    }
}
