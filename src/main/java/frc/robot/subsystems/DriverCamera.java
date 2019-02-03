/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Deals with the servo controlling the position of the Driver Camera and the Driver Camera feed
 */
public class DriverCamera extends Subsystem {
  Servo driverCameraServo;

  /**
   * This is the constructor for the DriverCamera class
   * @param dcs
   */
  public DriverCamera(Servo dcs){
    driverCameraServo = dcs;
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
