/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class CargoOuttake extends Subsystem {
  public WPI_TalonSRX cargoOuttake;
/**
 * Setting Motor
 * @param cargoMotor Cargo Outtake Motor
 */
  public CargoOuttake(WPI_TalonSRX cargoMotor) {
    cargoOuttake = cargoMotor;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  /**
   * Sets speed for Cargo Outtake
   * @param speed Speed
   */
  public void setCargoSpeed(double speed){
    cargoOuttake.set(speed);
  }
}
