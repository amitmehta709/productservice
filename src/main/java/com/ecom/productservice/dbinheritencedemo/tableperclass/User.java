package com.ecom.productservice.dbinheritencedemo.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
