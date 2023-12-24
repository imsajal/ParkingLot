package com.example.ParkingLot.strategy;

import com.example.ParkingLot.model.Slot;

public interface ParkingStrategy {

    void addSlot(Integer slotNumber);
    void removeSlot(Integer slotNumber);
    Integer getAndRemoveNextAvailableSlot();
}
