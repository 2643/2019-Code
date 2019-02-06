/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Deals with the servo controlling the position of the Driver Camera and the Driver Camera feed
 */
public class DriverCamera extends Subsystem {
  Servo driverCameraServo1;
  Servo driverCameraServo2;
  UsbCamera driverCamera1;
  UsbCamera driverCamera2;

  /**
   * This is the constructor for the DriverCamera class
   * @param dcs
   */
  public DriverCamera(Servo servo1, Servo servo2, UsbCamera camera1, UsbCamera camera2){
    driverCameraServo1 = servo1;
    driverCameraServo2 = servo2;
    driverCamera1 = camera1;
    driverCamera2 = camera2;
  }

  public void setServo1Angle(double degrees){
    RobotMap.driverCameraServo1.setAngle(degrees);
  }

  public void setServo2Angle(double degrees){
    RobotMap.driverCameraServo2.setAngle(degrees);
  }

  public void setCameraSource(UsbCamera camera){
    RobotMap.server.setSource(camera);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
