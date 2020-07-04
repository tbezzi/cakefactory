package com.cakefactory.eshop.repository;

import com.cakefactory.eshop.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository
        extends CrudRepository<Item, String> {

}