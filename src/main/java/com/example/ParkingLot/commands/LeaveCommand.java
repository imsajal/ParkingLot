package com.example.ParkingLot.commands;

import com.example.ParkingLot.model.Command;
import com.example.ParkingLot.service.ParkingLotService;
import com.example.ParkingLot.util.Printer;

import java.util.Objects;

import static com.example.ParkingLot.constants.ParkingLotConstants.LEAVE_MESSAGE;

public class LeaveCommand extends CommandExecutor{

    public static String COMMAND = "leave";

    private ParkingLotService parkingLotService;


    public LeaveCommand(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }



    @Override
    boolean validate(Command command) {

        return Objects.nonNull(command.getAttributes()) && command.getAttributes().size() == 1;
    }

    @Override
    void execute(Command command) {

        Integer slotNumber = Integer.valueOf(command.getAttributes().get(0));

        parkingLotService.freeSlot(slotNumber);

        Printer.print(LEAVE_MESSAGE + slotNumber);

    }
}
