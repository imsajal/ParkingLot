package com.example.ParkingLot.commands;

import com.example.ParkingLot.model.Command;
import com.example.ParkingLot.service.ParkingLotService;
import com.example.ParkingLot.util.Printer;

import java.util.List;
import java.util.Objects;

import static com.example.ParkingLot.constants.ParkingLotConstants.STATUS_MESSAGE;

public class StatusCommand extends CommandExecutor {

    public static String COMMAND = "status";

    private ParkingLotService parkingLotService;


    public StatusCommand(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;

    }

    @Override
    boolean validate(Command command) {
        return Objects.nonNull(command.getAttributes()) && command.getAttributes().size() == 1;
    }

    @Override
    void execute(Command command) {

        List<String> parkingLotStatus = parkingLotService.statusOfParkingLot();
        Printer.print(STATUS_MESSAGE);
        parkingLotStatus.forEach(Printer::print);
    }
}
