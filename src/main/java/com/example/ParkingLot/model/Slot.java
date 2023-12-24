package com.example.ParkingLot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
public class Slot {

    public Slot(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    @Setter
    private Car car;
    private Integer slotNumber;

}
