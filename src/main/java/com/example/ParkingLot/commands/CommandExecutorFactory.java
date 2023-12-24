package com.example.ParkingLot.commands;

import ch.qos.logback.core.status.Status;
import com.example.ParkingLot.exceptions.InvalidCommandException;
import com.example.ParkingLot.model.Command;
import com.example.ParkingLot.service.ParkingLotService;
import com.example.ParkingLot.strategy.ParkingStrategy;
import org.apache.tomcat.util.buf.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommandExecutorFactory {

    private ParkingLotService parkingLotService;


    public CommandExecutorFactory(ParkingLotService parkingLotService, ParkingStrategy parkingStrategy) {
        this.parkingLotService = parkingLotService;
    }

    Map<String, CommandExecutor> commandExecutorMap = new HashMap<>();

    public CommandExecutorFactory() {

        commandExecutorMap.put(ExitCommand.COMMAND, new ExitCommand(parkingLotService));
        commandExecutorMap.put(CreateParkingLotCommand.COMMAND, new CreateParkingLotCommand(parkingLotService));
        commandExecutorMap.put(LeaveCommand.COMMAND, new LeaveCommand(parkingLotService));
        commandExecutorMap.put(ParkCommand.COMMAND, new ParkCommand(parkingLotService));

        commandExecutorMap.put(RegistrationNumberForCarsWithColourCommand.COMMAND, new RegistrationNumberForCarsWithColourCommand(parkingLotService));
        commandExecutorMap.put(SlotNumberForRegistrationNumberCommand.COMMAND, new SlotNumberForRegistrationNumberCommand(parkingLotService));
        commandExecutorMap.put(SlotNumbersForCarsWithColourCommand.COMMAND, new SlotNumbersForCarsWithColourCommand(parkingLotService));
        commandExecutorMap.put(StatusCommand.COMMAND, new StatusCommand(parkingLotService));

    }

    public CommandExecutor getCommandExecutor(Command command){

        if(Objects.nonNull(command.getName()) &&
                commandExecutorMap.containsKey(command.getName())){
            return commandExecutorMap.get(command.getName());
        }

        else throw new InvalidCommandException("Command Not Valid");
    }
}
