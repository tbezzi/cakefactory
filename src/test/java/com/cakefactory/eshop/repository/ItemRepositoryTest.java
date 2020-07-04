package com.cakefactory.eshop.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(itemRepository).isNotNull();
    }

    @Test
    void findAllItemsReturnsSomeRecords() {
        assertThat(itemRepository.findAll()).isNotNull();
    }
}
