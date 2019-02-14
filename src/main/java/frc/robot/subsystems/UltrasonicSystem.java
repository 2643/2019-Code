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
  public double[] getLeftValues() {
    double leftOne = -1.0;
    double leftTwo = -1.0;
    double[] array = new double[2];
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
    array[0] = leftOne;
    array[1] = leftTwo;
    return(array);
  }
  
  public double[] getRightValues() {
    double[] array = new double[1];
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

    array[0] = rightOne;
    array[1] = rightTwo;

    return(array);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
