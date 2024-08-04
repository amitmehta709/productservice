package com.ecom.productservice.dbinheritencedemo.tableperclass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_instructor")
public class Instructor extends User {

    @Column(name="it_specialisation")
    private String specialisation;
}
