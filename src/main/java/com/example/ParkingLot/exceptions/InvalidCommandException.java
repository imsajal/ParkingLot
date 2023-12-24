package com.example.ParkingLot.exceptions;

public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException() {
    }

    public InvalidCommandException(String command_not_valid) {
        super(command_not_valid);
    }
}
