package com.example.ParkingLot.service.impl;

import com.example.ParkingLot.exceptions.*;
import com.example.ParkingLot.model.Car;
import com.example.ParkingLot.model.ParkingLot;
import com.example.ParkingLot.model.Slot;
import com.example.ParkingLot.service.ParkingLotService;
import com.example.ParkingLot.strategy.ParkingStrategy;
import com.example.ParkingLot.util.Printer;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.ParkingLot.constants.ParkingLotConstants.*;

public class ParkingLotServiceImpl implements ParkingLotService {

    private ParkingStrategy parkingStrategy;
    private ParkingLot parkingLot;


    public ParkingLotServiceImpl(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    @Override
    public void createParkingLot(Integer numberOfSlots) {

        if (parkingLot != null)
            throw new ParkingLotAlreadyExistException();

        if (numberOfSlots < 1 || numberOfSlots > MAXIMUM_CAPACITY_OF_PARKING_LOT)
            throw new InvalidParkingCapacityException();

        this.parkingLot = new ParkingLot(numberOfSlots);

        for (int i = 1; i <= numberOfSlots; i++) {

            parkingLot.getSlots().put(i, new Slot(i));
            parkingStrategy.addSlot(i);
        }

    }

    @Override
    public Integer park(String registrationNumber, String colour) {

        Integer availableSlotNumber = parkingStrategy.getAndRemoveNextAvailableSlot();

        Car car = new Car(registrationNumber, colour);

        parkingLot.getSlots().get(availableSlotNumber).setCar(car);

        return availableSlotNumber;

    }

    @Override
    public void freeSlot(Integer slotNumber) {

        if (!parkingLot.getSlots().containsKey(slotNumber))
            throw new InvalidSlotNumberException();

        if (parkingLot.getSlots().get(slotNumber).getCar() == null)
            throw new SlotAlreadyEmptiedException();

        parkingLot.getSlots().get(slotNumber).setCar(null);
        parkingStrategy.addSlot(slotNumber);

    }

    @Override
    public List<String> statusOfParkingLot() {

        if (parkingLot == null) throw new ParkingLotEmptyException();

        return parkingLot.getSlots().values().stream()
                .map(slot -> String.valueOf(slot.getSlotNumber()) + " "
                        + slot.getCar().getRegistrationNumber() + " "
                        + slot.getCar().getColour()).collect(Collectors.toList());

    }

    @Override
    public List<String> getResistrationNumbersOfCarsByColour(String colour) {

        if (parkingLot == null) throw new ParkingLotEmptyException();

        return parkingLot.getSlots().values().stream().filter(
                slot -> slot.getCar() != null && colour.equalsIgnoreCase(slot.getCar().getColour()))
                .map(slot -> slot.getCar().getRegistrationNumber()).collect(Collectors.toList());
    }

    @Override
    public List<Integer> getSlotNumbersOfCarsByColour(String colour) {

        if (parkingLot == null) throw new ParkingLotEmptyException();

        return parkingLot.getSlots().values().stream().filter(
                slot -> slot.getCar() != null && colour.equalsIgnoreCase(slot.getCar().getColour()))
                .map(slot -> slot.getSlotNumber()).collect(Collectors.toList());
    }

    @Override
    public String getslotNumbersByRegistrationNumber(String registrationNumber) {

        if (parkingLot == null) throw new ParkingLotEmptyException();

        Integer slotNumber = parkingLot.getSlots().values().stream().filter(
                slot -> slot.getCar() != null && registrationNumber.equalsIgnoreCase(slot.getCar().getRegistrationNumber()))
                .map(slot -> slot.getSlotNumber()).findFirst().orElse(null);

        return Objects.nonNull(slotNumber)? String.valueOf(slotNumber) : NOT_FOUND_MESSAGE;

    }
}
