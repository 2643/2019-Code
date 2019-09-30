/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.*;

/**
 * Add your docs here.
 */
public class Hatch extends Subsystem {
private WPI_TalonSRX HatchMotor2;

  public Hatch(WPI_TalonSRX HatchMotor1){
    HatchMotor2 = HatchMotor1;
  }
 
  public void setSpeed(double speed){
  
    HatchMotor2.set(speed);
  }
  
  public void initDefaultCommand(){

  }
}