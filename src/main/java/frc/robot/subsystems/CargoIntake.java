/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
/**
 * Add your docs here.
 */
public class CargoIntake extends Subsystem {
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
   * @param speed double from -1 to 1 
   */
  public void setIntakeSpeed(double speed){
    CargoIntake1.set(speed); 
    CargoIntake2.set(-speed); 
  }
  /**
   * Sets the speed for the Retract Motor
   * @param speed double from -1 to 1
   */
  public void setRectractSpeed(double speed){
    RetractMotor.set(speed); 
  }

  /**
   * returns the current of the cargo intake motor 
   * @return double the current that the motor controller is outputting 
   */
  public double getCurrent(){
    return RobotMap.cargoRetractMotor.getOutputCurrent();
  }

  /**
   * Returns whether the retract motor is at the top or not 
   * @return boolean is the motor at the top or not 
   */
  public boolean isFullyRetracted(){ //TODO Sanjana: implement encoder
    return false; 
  }

  public boolean isFullyReleased(){ 
    return false;
  }

}
