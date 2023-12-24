package com.example.ParkingLot;

import com.example.ParkingLot.mode.ApplicationMode;
import com.example.ParkingLot.mode.FileMode;
import com.example.ParkingLot.mode.InteractiveMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;


public class ParkingLotApplication {

	public static void main(String[] args) {
        if(isInteractiveMode(args)){

			InteractiveMode in = new InteractiveMode();

			//in.process



		}
		else if(isFileMode(args)){


		}
	}

	private static boolean isFileMode(String[] args) {

		return args.length == 1;
	}

	private static boolean isInteractiveMode(String[] args) {
		return args.length == 0;
	}

}
