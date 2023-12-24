package com.example.ParkingLot.commands;

import com.example.ParkingLot.model.Command;
import com.example.ParkingLot.service.ParkingLotService;
import com.example.ParkingLot.util.Printer;

import java.util.Objects;

public class SlotNumberForRegistrationNumberCommand extends CommandExecutor{

    public static String COMMAND = "slot_number_for_registration_number";

    private ParkingLotService parkingLotService;


    public SlotNumberForRegistrationNumberCommand(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;

    }


    @Override
    boolean validate(Command command) {

        return Objects.nonNull(command.getAttributes()) && command.getAttributes().size() == 1;
    }

    @Override
    void execute(Command command) {
        String registrationNumber = command.getAttributes().get(0);
        Printer.print(parkingLotService.getslotNumbersByRegistrationNumber(registrationNumber));

    }
}
