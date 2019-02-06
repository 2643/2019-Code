/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class UltrasonicSystem extends Subsystem {

   /**
   * Gets the angle at the left side of the robot in relation to the wall beside it.
   * @return left angle
   */
  public double getLeftAngle() {
    double angle = -1.0;
    double leftOne = -1.0;
    double leftTwo = -1.0;
    boolean ultrasonicPingWhichLeft = true;
    boolean ultrasonicLeftPing = true;

    if(ultrasonicPingWhichLeft) {
      if(ultrasonicLeftPing) {
        RobotMap.ultrasonicLeftOne.ping();
        ultrasonicLeftPing = false;
      }
      
      else {
        if(RobotMap.ultrasonicLeftOne.isRangeValid()){
          leftOne = Math.floor(RobotMap.ultrasonicLeftOne.getRangeInches());
          ultrasonicPingWhichLeft = !ultrasonicPingWhichLeft;
          ultrasonicLeftPing = true;
        }
      }
    }

    else {
      if(ultrasonicLeftPing) {
        RobotMap.ultrasonicLeftTwo.ping();
        ultrasonicLeftPing = false;
      }
      if(RobotMap.ultrasonicLeftTwo.isRangeValid()){
      leftTwo = Math.floor(RobotMap.ultrasonicLeftTwo.getRangeInches());
      ultrasonicPingWhichLeft = !ultrasonicPingWhichLeft;
      ultrasonicLeftPing = true;
      }
    }
    if(leftOne == -1.0 || leftTwo == -1.0) {
      return(Double.NaN);
    }

    angle = Math.atan(leftOne - leftTwo);
    return(angle);
  }
  
  public double getRightAngle() {
    double angle = -1.0;
    double rightOne = -1.0;
    double rightTwo = -1.0;
    boolean ultrasonicPingWhichRight = true;
    boolean ultrasonicRightPing = true;

    if(ultrasonicPingWhichRight) {
      if(ultrasonicRightPing) {
        RobotMap.ultrasonicRightOne.ping();
        ultrasonicRightPing = false;
      }
      
      else {
        if(RobotMap.ultrasonicRightOne.isRangeValid()){
          rightOne = Math.floor(RobotMap.ultrasonicRightOne.getRangeInches());
          ultrasonicPingWhichRight = !ultrasonicPingWhichRight;
          ultrasonicRightPing = true;
        }
      }
    }

    else {
      if(ultrasonicRightPing) {
        RobotMap.ultrasonicRightTwo.ping();
        ultrasonicRightPing = false;
      }
      if(RobotMap.ultrasonicRightTwo.isRangeValid()){
      rightTwo = Math.floor(RobotMap.ultrasonicRightTwo.getRangeInches());
      ultrasonicPingWhichRight = !ultrasonicPingWhichRight;
      ultrasonicRightPing = true;
      }
    }
    if(rightOne == -1.0 || rightTwo == -1.0) {
      return(Double.NaN);
    }

    angle = Math.atan(rightOne - rightTwo);
    return(angle);
  }

  public double getRightDist() {
    double angle = -1.0;
    double rightOne = -1.0;
    double rightTwo = -1.0;
    boolean ultrasonicPingWhichRight = true;
    boolean ultrasonicRightPing = true;

    if(ultrasonicPingWhichRight) {
      if(ultrasonicRightPing) {
        RobotMap.ultrasonicRightOne.ping();
        ultrasonicRightPing = false;
      }
      
      else {
        if(RobotMap.ultrasonicRightOne.isRangeValid()){
          rightOne = Math.floor(RobotMap.ultrasonicRightOne.getRangeInches());
          ultrasonicPingWhichRight = !ultrasonicPingWhichRight;
          ultrasonicRightPing = true;
        }
      }
    }

    else {
      if(ultrasonicRightPing) {
        RobotMap.ultrasonicRightTwo.ping();
        ultrasonicRightPing = false;
      }
      if(RobotMap.ultrasonicRightTwo.isRangeValid()){
      rightTwo = Math.floor(RobotMap.ultrasonicRightTwo.getRangeInches());
      ultrasonicPingWhichRight = !ultrasonicPingWhichRight;
      ultrasonicRightPing = true;
      }
    }
    if(rightOne == -1.0 || rightTwo == -1.0) {
      return(Double.NaN);
    }

    angle = Math.min(rightOne, rightTwo);
    return(angle);
  }

  public double getLeftDist() {
    double angle = -1.0;
    double leftOne = -1.0;
    double leftTwo = -1.0;
    boolean ultrasonicPingWhichLeft = true;
    boolean ultrasonicLeftPing = true;

    if(ultrasonicPingWhichLeft) {
      if(ultrasonicLeftPing) {
        RobotMap.ultrasonicLeftOne.ping();
        ultrasonicLeftPing = false;
      }
      
      else {
        if(RobotMap.ultrasonicLeftOne.isRangeValid()){
          leftOne = Math.floor(RobotMap.ultrasonicLeftOne.getRangeInches());
          ultrasonicPingWhichLeft = !ultrasonicPingWhichLeft;
          ultrasonicLeftPing = true;
        }
      }
    }

    else {
      if(ultrasonicLeftPing) {
        RobotMap.ultrasonicLeftTwo.ping();
        ultrasonicLeftPing = false;
      }
      if(RobotMap.ultrasonicLeftTwo.isRangeValid()){
      leftTwo = Math.floor(RobotMap.ultrasonicLeftTwo.getRangeInches());
      ultrasonicPingWhichLeft = !ultrasonicPingWhichLeft;
      ultrasonicLeftPing = true;
      }
    }
    if(leftOne == -1.0 || leftTwo == -1.0) {
      return(Double.NaN);
    }

    angle = Math.min(leftOne, leftTwo);
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
