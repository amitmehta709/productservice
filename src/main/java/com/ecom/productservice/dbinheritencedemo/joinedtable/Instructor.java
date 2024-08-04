package com.ecom.productservice.dbinheritencedemo.joinedtable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_instructor")
public class Instructor extends User {

    @Column(name="it_specialisation")
    private String specialisation;
}
