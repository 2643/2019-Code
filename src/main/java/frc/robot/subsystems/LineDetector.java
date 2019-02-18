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

  // Obsolete
  /*
   * public DigitalInput[][] getIrSensors() { DigitalInput[][] sensorArray =
   * {{RobotMap.irLeft1, RobotMap.irRight1}, {RobotMap.irLeft2,
   * RobotMap.irRight1}, {RobotMap.irLeft3, RobotMap.irRight3}, {RobotMap.irLeft4,
   * RobotMap.irRight4}}; return sensorArray; }
   */

  public static final int SENSOR_L1 = 1 << 0;
  public static final int SENSOR_L2 = 1 << 1;
  public static final int SENSOR_L3 = 1 << 2;
  public static final int SENSOR_R1 = 1 << 3;
  public static final int SENSOR_R2 = 1 << 4;
  public static final int SENSOR_R3 = 1 << 5;

  public int getIRSensors() {
    switch (RobotMap.curIRStateLeftOne) {
    case IDLE:
      if (!RobotMap.irLeft1.get()) {
        RobotMap.curIRStateLeftOne = RobotMap.IRState.TRUE;
      }
    case TRUE:
      RobotMap.counterLeftOne = 3;
      if (RobotMap.irLeft1.get()) {
        RobotMap.curIRStateLeftOne = RobotMap.IRState.WAIT;
      }
    case WAIT:
      if (!RobotMap.irLeft1.get()) {
        RobotMap.curIRStateLeftOne = RobotMap.IRState.TRUE;
      } else {
        if (RobotMap.irLeft1.get()) {
          RobotMap.counterLeftOne -= 1;
        } else {
          RobotMap.curIRStateLeftOne = RobotMap.IRState.IDLE;
        }
      }
    }
    switch (RobotMap.curIRStateLeftTwo) {
    case IDLE:
      if (!RobotMap.irLeft2.get()) {
        RobotMap.curIRStateLeftTwo = RobotMap.IRState.TRUE;
      }
    case TRUE:
      RobotMap.counterLeftTwo = 3;
      if (RobotMap.irLeft2.get()) {
        RobotMap.curIRStateLeftTwo = RobotMap.IRState.WAIT;
      }
    case WAIT:
      if (!RobotMap.irLeft2.get()) {
        RobotMap.curIRStateLeftTwo = RobotMap.IRState.TRUE;
      } else {
        if (RobotMap.irLeft2.get()) {
          RobotMap.counterLeftTwo -= 1;
        } else {
          RobotMap.curIRStateLeftTwo = RobotMap.IRState.IDLE;
        }
      }
    }
    switch (RobotMap.curIRStateLeftThree) {
    case IDLE:
      if (!RobotMap.irLeft3.get()) {
        RobotMap.curIRStateLeftThree = RobotMap.IRState.TRUE;
      }
    case TRUE:
      RobotMap.counterLeftThree = 3;
      if (RobotMap.irLeft3.get()) {
        RobotMap.curIRStateLeftThree = RobotMap.IRState.WAIT;
      }
    case WAIT:
      if (!RobotMap.irLeft3.get()) {
        RobotMap.curIRStateLeftThree = RobotMap.IRState.TRUE;
      } else {
        if (RobotMap.irLeft3.get()) {
          RobotMap.counterLeftThree -= 1;
        } else {
          RobotMap.curIRStateLeftThree = RobotMap.IRState.IDLE;
        }
      }
    }
    switch (RobotMap.curIRStateRightOne) {
    case IDLE:
      if (!RobotMap.irRight1.get()) {
        RobotMap.curIRStateRightOne = RobotMap.IRState.TRUE;
      }
    case TRUE:
      RobotMap.counterRightOne = 3;
      if (RobotMap.irRight1.get()) {
        RobotMap.curIRStateRightOne = RobotMap.IRState.WAIT;
      }
    case WAIT:
      if (!RobotMap.irRight1.get()) {
        RobotMap.curIRStateRightOne = RobotMap.IRState.TRUE;
      } else {
        if (RobotMap.irRight1.get()) {
          RobotMap.counterRightOne -= 1;
        } else {
          RobotMap.curIRStateRightOne = RobotMap.IRState.IDLE;
        }
      }
    }
    switch (RobotMap.curIRStateRightTwo) {
    case IDLE:
      if (!RobotMap.irRight2.get()) {
        RobotMap.curIRStateRightTwo = RobotMap.IRState.TRUE;
      }
    case TRUE:
      RobotMap.counterRightTwo = 3;
      if (RobotMap.irRight2.get()) {
        RobotMap.curIRStateRightTwo = RobotMap.IRState.WAIT;
      }
    case WAIT:
      if (!RobotMap.irRight2.get()) {
        RobotMap.curIRStateRightTwo = RobotMap.IRState.TRUE;
      } else {
        if (RobotMap.irRight2.get()) {
          RobotMap.counterRightTwo -= 1;
        } else {
          RobotMap.curIRStateRightTwo = RobotMap.IRState.IDLE;
        }
      }
    }
    switch (RobotMap.curIRStateRightTwo) {
    case IDLE:
      if (!RobotMap.irRight2.get()) {
        RobotMap.curIRStateRightTwo = RobotMap.IRState.TRUE;
      }
    case TRUE:
      RobotMap.counterRightTwo = 3;
      if (RobotMap.irRight2.get()) {
        RobotMap.curIRStateRightTwo = RobotMap.IRState.WAIT;
      }
    case WAIT:
      if (!RobotMap.irRight2.get()) {
        RobotMap.curIRStateRightTwo = RobotMap.IRState.TRUE;
      } else {
        if (RobotMap.irRight2.get()) {
          RobotMap.counterRightTwo -= 1;
        } else {
          RobotMap.curIRStateRightTwo = RobotMap.IRState.IDLE;
        }
      }
    }
  
  int sensorsOn = 0;
  if(RobotMap.counterLeftOne >= 1 && RobotMap.counterLeftTwo >=1 ) { 
    sensorsOn |= SENSOR_L1;
    sensorsOn |= SENSOR_L2;
  }

  if(RobotMap.counterLeftTwo >= 1 && RobotMap.counterLeftTwo >= 1 ) {
    sensorsOn |= SENSOR_L3;
    sensorsOn |= SENSOR_L2;
  }
  if(RobotMap.counterRightOne >= 1 && RobotMap.counterRightTwo >=1 ) { 
    sensorsOn |= SENSOR_R1;
    sensorsOn |= SENSOR_R2;
  }

  if(RobotMap.counterRightTwo >= 1 && RobotMap.counterRightTwo >= 1 ) {
    sensorsOn |= SENSOR_R3;
    sensorsOn |= SENSOR_R2;
  }
  return(sensorsOn);

   }
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
