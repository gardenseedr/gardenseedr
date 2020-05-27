package com.gardenseedr.gardenseedr.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="gardens")
public class Garden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "garden_name", nullable = false)
    private String garden_name;

    @Column(name = "created", nullable = false)
    private String created;

    @Column(name="updated")
    private String updated;

    //  Many Gardens to one User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //  One Garden to many Squares
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garden")
    private List<Square> squares;



    // ------------------------- Constructors
    // Empty
    public Garden (){}
    // garden_name, created, updated
    public Garden (String garden_name, String created, String updated){
        this.garden_name = garden_name;
        this.created = created;
        this.updated = updated;
    }
    // garden_name, created
    public Garden (String garden_name, String created){
        this.garden_name = garden_name;
        this.created = created;
    }
    // Every field included
    public Garden (long id, String garden_name, String created, String updated, User user){
        this.id = id;
        this.garden_name = garden_name;
        this.created = created;
        this.updated = updated;
        this.user = user;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Square> getSquares() {
        return squares;
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getGarden_name() {
        return garden_name;
    }

    public void setGarden_name(String garden_name) {
        this.garden_name = garden_name;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}