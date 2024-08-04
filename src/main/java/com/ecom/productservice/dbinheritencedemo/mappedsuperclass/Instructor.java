package com.ecom.productservice.dbinheritencedemo.mappedsuperclass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mps_instructor")
public class Instructor extends User {

    @Column(name="it_specialisation")
    private String specialisation;
}
