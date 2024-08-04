package com.ecom.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String title;

//    @OneToMany(mappedBy = "category")
//    private List<Product> products; //lazy fetch
    // fetch query select * from category join
   // Select * from product where category_id = id
    //Avoid circular dependency
}
