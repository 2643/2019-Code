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
    int leftSensors = 0;

    //This puts the numbers in to binary form, outside-in, front-back.

    if(RobotMap.irLeft1.get()) {
      leftSensors += 16; // 1xxxx
    }

    if(RobotMap.irLeft2.get()) {
      leftSensors += 4; // x1xxx
    }

    if(RobotMap.irLeft3.get()) {
      leftSensors += 1; // xx1xx
    }

    if(RobotMap.irLeft4.get()) {
      leftSensors += 2; // xxx1x
    }

    if(RobotMap.irLeft5.get()){
      leftSensors += 8; // xxxx1
    }
    return(leftSensors);
  }

  /**
   * Tells which sensors on Right side are tripped.
   * @return right sensor values
   */
  public int getRightSensors() {
    int rightSensors = 0;

    //This puts the numbers in to binary form, outside-in, front-back.

    if(RobotMap.irRight1.get()) {
      rightSensors += 16; // 1xxxx
    }

    if(RobotMap.irRight2.get()) {
      rightSensors += 4; // x1xxx
    }

    if(RobotMap.irRight3.get()) {
      rightSensors += 1; // xx1xx
    }

    if(RobotMap.irRight4.get()) {
      rightSensors += 2; // xx1xx
    }

    if(RobotMap.irRight5.get()){
      rightSensors += 8; // xx1xx
    }

    return(rightSensors);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
