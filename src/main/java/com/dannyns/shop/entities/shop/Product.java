package com.dannyns.shop.entities.shop;

import com.dannyns.shop.entities.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Product extends BaseEntity {

    private String code;
    private String name;
    private String description;
}
