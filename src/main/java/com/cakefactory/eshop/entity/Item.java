package com.cakefactory.eshop.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity(name = "catalog")
public class Item {
    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private BigDecimal price;

}
