package com.example.ParkingLot.commands;

import com.example.ParkingLot.mode.InteractiveMode;
import com.example.ParkingLot.model.Command;
import com.example.ParkingLot.service.ParkingLotService;
import com.example.ParkingLot.strategy.ParkingStrategy;
import com.example.ParkingLot.util.Printer;

import java.util.Objects;

import static com.example.ParkingLot.constants.ParkingLotConstants.CREATE_PARKING_LOT_MESSAGE;

public class CreateParkingLotCommand extends CommandExecutor {

    public static String COMMAND = "create_parking_lot";

    private ParkingLotService parkingLotService;


    public CreateParkingLotCommand(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }


    @Override
    boolean validate(Command command) {
        boolean validCommand = false;
        try {
            if (Objects.nonNull(command.getAttributes()) && command.getAttributes().size() == 1) {
                Integer.valueOf(command.getAttributes().get(0));
                validCommand = true;
            }
        } catch (NumberFormatException e) {
        }
        return validCommand;
    }

    @Override
    void execute(Command command) {

        Integer numberOfSlots = Integer.valueOf(command.getAttributes().get(0));

        parkingLotService.createParkingLot(numberOfSlots);
        Printer.print(CREATE_PARKING_LOT_MESSAGE + numberOfSlots);
    }
}
