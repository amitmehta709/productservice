package com.ecom.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Category category;  //Eager Fetch
    private String description;
    private double rating;
}
