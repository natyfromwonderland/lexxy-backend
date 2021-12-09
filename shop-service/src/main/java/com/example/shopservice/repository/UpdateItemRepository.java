package com.example.shopservice.repository;

import com.example.shopservice.dao.AvatarUpdateItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateItemRepository extends JpaRepository<AvatarUpdateItem, Long> {

}
