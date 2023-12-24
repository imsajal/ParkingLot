package com.example.ParkingLot.commands;

import com.example.ParkingLot.model.Command;
import com.example.ParkingLot.service.ParkingLotService;
import com.example.ParkingLot.strategy.ParkingStrategy;

import java.util.Objects;

public class ExitCommand extends CommandExecutor{



    public static String COMMAND = "EXIT";

    private ParkingLotService parkingLotService;
    private ParkingStrategy parkingStrategy;

    public ExitCommand(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }


    @Override
    boolean validate(Command command) {

        return Objects.nonNull(command.getAttributes()) && command.getAttributes().size() == 1;
    }

    @Override
    void execute(Command command) {

    }
}
