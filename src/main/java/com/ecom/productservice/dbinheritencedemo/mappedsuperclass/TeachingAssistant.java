package com.ecom.productservice.dbinheritencedemo.mappedsuperclass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="mps_ta")
public class TeachingAssistant extends User{
    @Column(name="ta_no_session")
    private int numberOfSession;

    @Column(name="ta_avg_rating")
    private double avgRating;
}
