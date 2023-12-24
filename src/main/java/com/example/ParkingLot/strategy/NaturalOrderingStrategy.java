package com.example.ParkingLot.strategy;

import com.example.ParkingLot.exceptions.InvalidSlotNumberException;


import java.util.TreeSet;

public class NaturalOrderingStrategy implements ParkingStrategy
{
    TreeSet<Integer> availableSlots = new TreeSet<>();

    @Override
    public void addSlot(Integer slotNumber) {
           availableSlots.add(slotNumber);
    }

    @Override
    public void removeSlot(Integer slotNumber) {
           if(!availableSlots.contains(slotNumber)) throw new InvalidSlotNumberException();
           availableSlots.remove(slotNumber);
    }

    @Override
    public Integer getAndRemoveNextAvailableSlot() {
        if(availableSlots.isEmpty()) return 0;
        return availableSlots.pollFirst();
    }
}
