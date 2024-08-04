package com.ecom.productservice.dbinheritencedemo.singletable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_instructor")
@DiscriminatorValue(value = "3")
public class Instructor extends User {

    @Column(name="it_specialisation")
    private String specialisation;
}
