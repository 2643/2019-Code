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

  //Obsolete
/*   public DigitalInput[][] getIrSensors() {
    DigitalInput[][] sensorArray = 
     {{RobotMap.irLeft1, RobotMap.irRight1},
      {RobotMap.irLeft2, RobotMap.irRight1},
      {RobotMap.irLeft3, RobotMap.irRight3},
      {RobotMap.irLeft4, RobotMap.irRight4}};
    return sensorArray;
  } */
  /**
   * Tells when a sensor is tripped.
   * @return sensor values
   */



  public static int SENSOR_L1 = 1 << 0;
  public static int SENSOR_L2 = 1 << 1;
  public static int SENSOR_L3 = 1 << 2;
  public static int SENSOR_R1 = 1 << 3;
  public static int SENSOR_R2 = 1 << 4;
  public static int SENSOR_R3 = 1 << 5;
  
  public int getIRSensors()
  {
    int sensorsOn = 0;
    if(RobotMap.irLeft1.get())
    {
      sensorsOn |= SENSOR_L1;
    }

    if(RobotMap.irLeft2.get())
    {
      sensorsOn |= SENSOR_L2;
    }

    if(RobotMap.irLeft3.get())
    {
      sensorsOn |= SENSOR_L3;
    }

    if(RobotMap.irRight1.get())
    {
      sensorsOn |= SENSOR_R1;
    }
    if(RobotMap.irRight2.get())
    {
      sensorsOn |= SENSOR_R2;
    }
    if(RobotMap.irRight3.get())
    {
      sensorsOn |= SENSOR_R3;
    }
    return(sensorsOn);
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
