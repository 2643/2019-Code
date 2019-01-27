/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Moves the "carriage" system at the top of the elevator.
 * 
 * @return
 */
public class Carriage extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX Carriage;
  /**
   * Setting Motors
   * @param carriageMotor Carriage Motor
   */
  public Carriage(WPI_TalonSRX carriageMotor) {
    Carriage = carriageMotor;
  }

  /**
   * Sets the Carriage speed.
   * @param speed
   */
  public void setCarriageSpeed(double speed) {
    Carriage.set(speed);
  }
  /**\
   * Gets Carriage Potentiometer
   */
  public double getPotentiometer(){
    return RobotMap.carriagePot.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
