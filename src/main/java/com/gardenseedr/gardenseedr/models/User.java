package com.gardenseedr.gardenseedr.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "first_name", nullable = false)
    private String first_name;

    @Column (name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column (name = "zipcode", nullable = false)
    private int zipcode;

    @Column (name = "is_admin", nullable = false)
    private boolean is_admin;

    @Column (name = "email_updates", nullable = false)
    private boolean email_updates;

    //  One User to many Gardens
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Garden> gardens;


    // ------------------------- Constructors
    // Empty
    public User (){}
    // Every field but id included
    public User (String first_name, String last_name, String username, String email, String password, int zipcode, boolean is_admin, boolean email_updates){
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.zipcode = zipcode;
        this.is_admin = is_admin;
        this.email_updates = email_updates;
    }
    // Every field included
    public User (long id, String first_name, String last_name, String username, String email, String password, int zipcode, boolean is_admin, boolean email_updates){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.zipcode = zipcode;
        this.is_admin = is_admin;
        this.email_updates = email_updates;
    }
}
