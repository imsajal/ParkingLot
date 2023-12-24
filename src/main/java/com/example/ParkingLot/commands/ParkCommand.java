package com.example.ParkingLot.commands;

import com.example.ParkingLot.model.Command;
import com.example.ParkingLot.service.ParkingLotService;
import com.example.ParkingLot.util.Printer;

import java.util.Objects;

import static com.example.ParkingLot.constants.ParkingLotConstants.PARK_MESSAGE;

public class ParkCommand extends CommandExecutor {

    public static String COMMAND = "park";

    private ParkingLotService parkingLotService;


    public ParkCommand(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }


    @Override
    boolean validate(Command command) {
        return Objects.nonNull(command.getAttributes()) && command.getAttributes().size() == 2;
    }

    @Override
    void execute(Command command) {

        String registrationNUmber = command.getAttributes().get(0);
        String colour = command.getAttributes().get(1);

        Integer parkingSlotNumber = parkingLotService.park(registrationNUmber,colour);
        Printer.print(PARK_MESSAGE + parkingSlotNumber);

    }
}
