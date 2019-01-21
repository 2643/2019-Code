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
public class CargoIntake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX CargoIntake1;
  public WPI_TalonSRX CargoIntake2;
  public WPI_TalonSRX RetractMotor;


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  /**
   * Setting Motors
   * @param intakeMotor1 First Intake Motor
   * @param intakeMotor2 Second Intake Motor
   * @param retractMotor Motor that causes intake to move up and down
   */
  public CargoIntake (WPI_TalonSRX intakeMotor1, WPI_TalonSRX intakeMotor2, WPI_TalonSRX retractMotor){
    CargoIntake1 = intakeMotor1;
    CargoIntake2 = intakeMotor2;
    RetractMotor = retractMotor;

  }
  /**
   * Sets the speed for Intake Motors
   * @param speed Speed
   */
  public void setIntakeSpeed(double speed){
    CargoIntake1.set(speed); //TODO Test this
    CargoIntake2.set(speed); //TODO Test this
  }
  /**
   * Sets the speed for the Retract Motor
   * @param speed
   */
  public void setRectractSpeed(double speed){
    RetractMotor.set(speed); //TODO Test this
  }
}
