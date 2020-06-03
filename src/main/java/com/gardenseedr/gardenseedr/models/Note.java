package com.gardenseedr.gardenseedr.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

    @Entity
    @Table(name="notes")
    public class Note {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column (name = "created", nullable = false)
        private LocalDate created;

        @Column (name = "body", nullable = false)
        private String body;


        //  Many Notes to one Square
        @ManyToOne
        @JoinColumn(name = "square_id")
        private Square square;

//    No constructor(s) cause it should not change after values are seeded

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }

        public LocalDate getCreated() {
            return created;
        }
        public void setCreated(LocalDate API_id) {
            this.created = created;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public Square getSquare() {
            return square;
        }

        public void setSquare(Square square) {
            this.square = square;
        }
    }

