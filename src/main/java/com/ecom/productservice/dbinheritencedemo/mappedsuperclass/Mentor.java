package com.ecom.productservice.dbinheritencedemo.mappedsuperclass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mps_mentor")
public class Mentor extends User{
    @Column(name = "mentor_comp_name")
    private String compName;

    @Column(name = "mentor_avg_rating")
    private double avgRating;
}
