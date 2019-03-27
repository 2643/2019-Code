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
public class UltrasonicSubsystem extends Subsystem {

   /**
   * Gets the angle at the left side of the robot in relation to the wall beside it.
   * @return left in array
   */
  public int[] getLeftValues() {
    int[] leftArray = new int[]{(int)RobotMap.ultrasonicLeftOne.getRangeMM(), (int)RobotMap.ultrasonicLeftTwo.getRangeMM()};
    return(leftArray);
  }
  /**  */
  public int[] getRightValues() {
    int[] rightArray = new int[]{(int)RobotMap.ultrasonicRightOne.getRangeMM(), (int)RobotMap.ultrasonicRightTwo.getRangeMM()};
    return(rightArray);
  }

  public int getLeftDist() {
    return(Math.min(getLeftValues()[0],getLeftValues()[1]));
  }

  public int getRightDist() {
    return(Math.min(getRightValues()[0],getRightValues()[1]));
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
