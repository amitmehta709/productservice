package com.ecom.productservice.dbinheritencedemo.singletable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_ta")
@DiscriminatorValue(value = "1")
public class TeachingAssistant extends User {
    @Column(name="ta_no_session")
    private int numberOfSession;

    @Column(name="ta_avg_rating")
    private double avgRating;
}
