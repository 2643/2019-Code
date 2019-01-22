/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class CargoOuttake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_TalonSRX cargoOuttake;

  public CargoOuttake(WPI_TalonSRX cargoMotor) {
    cargoOuttake = cargoMotor;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public DigitalInput[][] getIrSensors() {
    DigitalInput[][] sensorArray = 
     {{RobotMap.irLeft1, RobotMap.irRight1},
      {RobotMap.irLeft2, RobotMap.irRight1},
      {RobotMap.irLeft3, RobotMap.irRight3},
      {RobotMap.irLeft4, RobotMap.irRight4}};
    return sensorArray;
  }
  /**
   * Tells when a sensor on the left side is tripped.
   * @return left sensors added value
   */
  public int getCargoLeftSensors() {
    int leftSensors = RobotMap.irLeftPort1+RobotMap.irLeftPort2+RobotMap.irLeftPort3+RobotMap.irLeftPort4;
    return(leftSensors);
  }

  public int getCargoRightSensors() {
    int rightSensors = RobotMap.irRightPort1+RobotMap.irRightPort2+RobotMap.irRightPort3+RobotMap.irLeftPort4;
    return(rightSensors);
  }
  public void setCargoSpeed(double speed){
    cargoOuttake.set(speed);
  }
}
