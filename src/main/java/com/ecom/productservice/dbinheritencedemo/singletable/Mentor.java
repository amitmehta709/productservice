package com.ecom.productservice.dbinheritencedemo.singletable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_mentor")
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    @Column(name = "mentor_comp_name")
    private String compName;

    @Column(name = "mentor_avg_rating")
    private double avgRating;
}
