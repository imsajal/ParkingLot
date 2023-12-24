package com.example.ParkingLot.commands;

import com.example.ParkingLot.model.Command;

public abstract class CommandExecutor {

     abstract boolean validate(Command command);

     abstract void execute(Command command);

}
