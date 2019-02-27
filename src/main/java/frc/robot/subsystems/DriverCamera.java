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
   * @param Servo left servo 
   * @param Servo right servo
   * @param UsbCamera left camera
   * @param UsbCamera right camera
   */
  public DriverCamera(Servo servo1, Servo servo2, UsbCamera camera1, UsbCamera camera2){
    driverCameraServo1 = servo1;
    driverCameraServo2 = servo2;
    driverCamera1 = camera1;
    driverCamera2 = camera2;
    setLeftServoAngle(RobotMap.forwardAngle);
    setRightServoAngle(RobotMap.forwardAngle);
    //setCameraSource(RobotMap.rightCamera);
  }

  /**
   * Sets the angle of servo1
   * @param degrees int angle from 0-360 to make the servo to turn to 
   */
  public void setLeftServoAngle(int degrees){
    RobotMap.leftDriverCameraServo.setAngle(degrees);
  }

  /**
   * Sets the angle of servo2
   * @param degrees int angle from 0
   */
  public void setRightServoAngle(int degrees){
    RobotMap.rightDriverCameraServo.setAngle(degrees);
  }

  /**
   * Changes the view to the camera given 
   * @param camera Camera that you want to change the view to 
   */
  public void setCameraSource(UsbCamera camera){
    //RobotMap.server.setSource(camera);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
