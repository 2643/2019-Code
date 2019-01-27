/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

//import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Sends information about line under robot.
 */
public class LineDetector extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Obsolete, better method implemented.
/*   public DigitalInput[][] getIrSensors() {
    DigitalInput[][] sensorArray = 
     {{RobotMap.irLeft1, RobotMap.irRight1},
      {RobotMap.irLeft2, RobotMap.irRight1},
      {RobotMap.irLeft3, RobotMap.irRight3},
      {RobotMap.irLeft4, RobotMap.irRight4}};
    return sensorArray;
  } */
  /**
   * Tells when a sensor is tripped.
   * @return sensor values, as primes multiplied
   */
  public int getIRSensors() {
    int sensorArray = 1;

    //This puts the numbers in as primes, modulo to find the lit ones.
    //This allows a single output to determine the status of the IRs

    if(RobotMap.irLeft1.get()) {
      sensorArray *= 5; // 1xx
    }

    if(RobotMap.irLeft2.get()) {
      sensorArray *= 3; // x1x
    }

    if(RobotMap.irLeft3.get()) {
      sensorArray *= 7; // xx1
    }

    if(RobotMap.irRight1.get()) {
      sensorArray *= 13; // 1xx
    }

    if(RobotMap.irRight2.get()) {
      sensorArray *= 11; // x1x
    }

    if(RobotMap.irRight3.get()) {
      sensorArray *= 17; // xx1
    }

    return(sensorArray);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
