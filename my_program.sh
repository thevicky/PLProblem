#!/bin/bash
# Call this script with file name as parameters, for example
# sh my_program.sh file_inputs.txt > output.txt
java -cp Jar/parking-1.0.0-jar-with-dependencies.jar com.parking.ParkingLotApp $1 $2 
