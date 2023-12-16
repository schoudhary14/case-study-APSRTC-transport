package com.apsrtc.busmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "buses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bus_reg_number",unique = true)
    private String busRegNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "bus_type")
    private BusType busType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusRegNumber() {
        return busRegNumber;
    }

    public void setBusRegNumber(String busRegNumber) {
        this.busRegNumber = busRegNumber;
    }

    public BusType getBusType() {
        return busType;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }

}

