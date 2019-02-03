/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/*
//Ultrasonic Initiation
  Ultrasonic ultrasonicLeftOne = new Ultrasonic(RobotMap.ultrasonicLeftOneTrigger, RobotMap.ultrasonicLeftOneEcho);
  Ultrasonic ultrasonicLeftTwo = new Ultrasonic(RobotMap.ultrasonicLeftTwoTrigger, RobotMap.ultrasonicLeftTwoEcho);
  Ultrasonic ultrasonicRightOne = new Ultrasonic(RobotMap.ultrasonicRightOneTrigger, RobotMap.ultrasonicRightOneEcho);
  Ultrasonic ultrasonicRightTwo = new Ultrasonic(RobotMap.ultrasonicRightTwoTrigger, RobotMap.ultrasonicRightTwoEcho);
*/

/**
 * Add your docs here.
 */
public class Ultrasonic extends Subsystem {

  public double getLeftAngle() {
    double angle = 0.0;
    double leftOne = 0.0;
    double leftTwo = 0.0;

    if(RobotMap.ultrasonicPingWhichLeft) {
      if(RobotMap.ultrasonicLeftPing) {
        RobotMap.ultrasonicLeftOne.ping();
        RobotMap.ultrasonicLeftPing = false;
      }
      
      else {
        if(RobotMap.ultrasonicLeftOne.isRangeValid()){
          leftOne = Math.floor(RobotMap.ultrasonicLeftOne.getRangeInches());
          RobotMap.ultrasonicPingWhichLeft = !RobotMap.ultrasonicPingWhichLeft;
          RobotMap.ultrasonicLeftPing = true;
        }
      }
    }

    else {
      if(RobotMap.ultrasonicLeftPing) {
        RobotMap.ultrasonicLeftTwo.ping();
        RobotMap.ultrasonicLeftPing = false;
      }
      if(RobotMap.ultrasonicLeftTwo.isRangeValid()){
      leftTwo = Math.floor(RobotMap.ultrasonicLeftTwo.getRangeInches());
      RobotMap.ultrasonicPingWhichLeft = !RobotMap.ultrasonicPingWhichLeft;
      RobotMap.ultrasonicLeftPing = true;
      }
    }
    angle = Math.atan(leftOne - leftTwo);
    return(angle);
  }

  
  public double getRightAngle() {
    double angle = 0.0;
    double rightOne = 0.0;
    double rightTwo = 0.0;

    if(RobotMap.ultrasonicPingWhichRight) {
      if(RobotMap.ultrasonicRightPing) {
        RobotMap.ultrasonicRightOne.ping();
        RobotMap.ultrasonicRightPing = false;
      }
      
      else {
        if(RobotMap.ultrasonicRightOne.isRangeValid()){
          rightOne = Math.floor(RobotMap.ultrasonicRightOne.getRangeInches());
          RobotMap.ultrasonicPingWhichRight = !RobotMap.ultrasonicPingWhichRight;
          RobotMap.ultrasonicRightPing = true;
        }
      }
    }

    else {
      if(RobotMap.ultrasonicRightPing) {
        RobotMap.ultrasonicRightTwo.ping();
        RobotMap.ultrasonicRightPing = false;
      }
      if(RobotMap.ultrasonicRightTwo.isRangeValid()){
      rightTwo = Math.floor(RobotMap.ultrasonicRightTwo.getRangeInches());
      RobotMap.ultrasonicPingWhichRight = !RobotMap.ultrasonicPingWhichRight;
      RobotMap.ultrasonicRightPing = true;
      }
    }
    angle = Math.atan(rightOne - rightTwo);
    return(angle);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
