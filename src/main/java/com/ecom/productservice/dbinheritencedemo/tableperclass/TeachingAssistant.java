package com.ecom.productservice.dbinheritencedemo.tableperclass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_ta")
public class TeachingAssistant extends User {
    @Column(name="ta_no_session")
    private int numberOfSession;

    @Column(name="ta_avg_rating")
    private double avgRating;
}
