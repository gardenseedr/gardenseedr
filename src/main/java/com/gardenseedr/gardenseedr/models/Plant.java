package com.gardenseedr.gardenseedr.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="plants")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "plant_name", nullable = false)
    private String plant_name;

    @Column (name = "API_id", nullable = false)
    private String API_id;

    //  One Plant to many Squares
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plant")
    private List<Square> squares;

//    No constructor(s) cause it should not change after values are seeded
}