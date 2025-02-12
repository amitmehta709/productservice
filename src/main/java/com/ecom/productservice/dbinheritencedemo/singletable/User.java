package com.ecom.productservice.dbinheritencedemo.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
public class User {
    @Id
    private Long id;

    @Column(name="usr_name")
    private String name;

    @Column(name="usr_email")
    private String email;

    @Column(name="usr_password")
    private String password;
}
