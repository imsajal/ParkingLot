package com.example.ParkingLot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Command {

    private String name;
    private List<String> attributes;
}
