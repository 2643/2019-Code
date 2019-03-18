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
public class Gyroscope extends Subsystem {
  // TODO ProbablyanAsian: Change to pigeonIMU.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  /**
   * Gets the angle of the gyroscope
   * @return the angle of the gyroscope in double 
   */
  public double getGyroAngle(){
    return(RobotMap.pigeonIMU.getFusedHeading());
  }

  /**
   * Sets the magnetic declination of the Pi(d)geonIMU.
   */
  public void setGyroDeclination(){
    RobotMap.pigeonIMU.setCompassDeclination(RobotMap.gyroCompassDeclination);
  }
  /**
   * Resets the angle of the gyroscope to 0
   */
  public void resetAngle(){
    RobotMap.pigeonIMU.setFusedHeading(0);
  }
}
