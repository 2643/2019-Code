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
   * Tells when a sensor on the left side is tripped.
   * @return left sensor values in binary values
   */
  public int getLeftSensors() {
    int leftSensors = 1;

    //This puts the numbers in as primes, modulo to find the lit ones.

    if(RobotMap.irLeft1.get()) {
      leftSensors *= 5; // 1xx
    }

    if(RobotMap.irLeft2.get()) {
      leftSensors *= 3; // x1x
    }

    if(RobotMap.irLeft3.get()) {
      leftSensors *= 7; // xx1
    }

    return(leftSensors);
  }

  /**
   * Tells which sensors on Right side are tripped.
   * @return right sensor values
   */
  public int getRightSensors() {
    int rightSensors = 1;

    //This puts the numbers in as primes, modulo to find the lit ones.

    if(RobotMap.irRight1.get()) {
      rightSensors *= 5; // 1xx
    }

    if(RobotMap.irRight2.get()) {
      rightSensors *= 3; // x1x
    }

    if(RobotMap.irRight3.get()) {
      rightSensors *= 7; // xx1
    }

    return(rightSensors);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
