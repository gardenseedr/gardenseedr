package com.gardenseedr.gardenseedr.models;

import javax.persistence.*;

@Entity
@Table(name="squares")
public class Square {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "square_num", nullable = false)
    private String square_num;

    @Column(name="plant_date", nullable = false)
    private String plant_date;


    //  Many Squares to one Garden
    @ManyToOne
    @JoinColumn(name = "garden_id")
    private Garden garden;

    //  Many Squares to one Plant
    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;



    // ------------------------- Constructors
    // Empty
    public Square (){}
    // Every field but id included
    public Square (String square_num, String plant_date, Garden garden, Plant plant){
        this.square_num = square_num;
        this.plant_date = plant_date;
        this.garden = garden;
        this.plant = plant;
    }
    // Every field included
    public Square (long id, String square_num, String plant_date, Garden garden, Plant plant){
        this.id = id;
        this.square_num = square_num;
        this.plant_date = plant_date;
        this.garden = garden;
        this.plant = plant;
    }
}