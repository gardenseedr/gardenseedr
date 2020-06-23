package com.gardenseedr.gardenseedr.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @Column (name = "pic_file_name", nullable = false)
    private String pic_file_name;

    //  One Plant to many Squares
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plant")
    @JsonBackReference
    private List<Square> squares;

    //    No constructor(s) cause it should not change after values are seeded

    // ------------------------- Getters and Setters

    public List<Square> getSquares() {
        return squares;
    }
    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getAPI_id() {
        return API_id;
    }
    public void setAPI_id(String API_id) {
        this.API_id = API_id;
    }

    public String getPlant_name() {
        return plant_name;
    }
    public void setPlant_name(String plant_name) {
        this.plant_name = plant_name;
    }

    public String getPic_file_name() {
        return pic_file_name;
    }
    public void setPic_file_name(String pic_file_name) {
        this.pic_file_name = pic_file_name;
    }
}