package com.example.ParkingLot.commands;

import com.example.ParkingLot.model.Command;
import com.example.ParkingLot.service.ParkingLotService;
import com.example.ParkingLot.util.Printer;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SlotNumbersForCarsWithColourCommand extends CommandExecutor{

    public static String COMMAND = "slot_numbers_for_cars_with_colour";

    private ParkingLotService parkingLotService;


    public SlotNumbersForCarsWithColourCommand(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    boolean validate(Command command) {
        return Objects.nonNull(command.getAttributes()) && command.getAttributes().size() == 1;
    }

    @Override
    void execute(Command command) {

        String colour = command.getAttributes().get(0);
        List<Integer> slotNumbers = parkingLotService.getSlotNumbersOfCarsByColour(colour);

        Printer.print(slotNumbers.stream().map(slotNumber -> String.valueOf(slotNumber))
                .collect(Collectors.joining(" ")));


    }
}
