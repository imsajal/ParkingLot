package com.example.ParkingLot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;


@Getter
public class ParkingLot {


    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
    }

    private Integer capacity;
    Map<Integer, Slot> slots = new HashMap<>();
}
