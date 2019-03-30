/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Deals with the servo controlling the position of the Driver Camera and the Driver Camera feed
 */
public class DriverCamera extends Subsystem {
  UsbCamera driverCamera1;
  UsbCamera driverCamera2; 

  /**
   * This is the constructor for the DriverCamera class
   * @param UsbCamera left camera
   */
  public DriverCamera(UsbCamera camera1, UsbCamera camera2){
    driverCamera1 = camera1;
    driverCamera2 = camera2;
  }

  /**
   * Gets the server that the cameras are using 
   * @return VideoSink the server that the cameras are using
   */
  public VideoSink getServer(){
    return RobotMap.server; 
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
