package com.ecom.productservice.dbinheritencedemo.mappedsuperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
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
