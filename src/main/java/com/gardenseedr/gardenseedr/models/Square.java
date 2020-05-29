package com.gardenseedr.gardenseedr.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="squares")
public class Square {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "square_num", nullable = false)
    private int square_num;

    @Column(name="plant_date", nullable = false)
    private LocalDate plant_date;


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
    public Square (int square_num, LocalDate plant_date, Garden garden, Plant plant){
        this.square_num = square_num;
        this.plant_date = plant_date;
        this.garden = garden;
        this.plant = plant;
    }
    // Every field included
    public Square (long id, int square_num, LocalDate plant_date, Garden garden, Plant plant){
        this.id = id;
        this.square_num = square_num;
        this.plant_date = plant_date;
        this.garden = garden;
        this.plant = plant;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Garden getGarden() {
        return garden;
    }
    public void setGarden(Garden garden) {
        this.garden = garden;
    }

    public Plant getPlant() {
        return plant;
    }
    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public LocalDate getPlant_date() {
        return plant_date;
    }
    public void setPlant_date(LocalDate plant_date) {
        this.plant_date = plant_date;
    }

    public int getSquare_num() {
        return square_num;
    }
    public void setSquare_num(int square_num) {
        this.square_num = square_num;
    }
}