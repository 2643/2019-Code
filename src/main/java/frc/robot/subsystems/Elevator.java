/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private CANSparkMax Elevator;
  private double encoderOffset; 
  
  private double kP;
  private double kI;
  private double kD;

  /**
   * Setting Motors
   * @param liftMotor elevator motor
   */
  public Elevator(CANSparkMax liftMotor) {
    Elevator = liftMotor;

    Elevator.getPIDController().setP(kP);
    Elevator.getPIDController().setI(kI);
    Elevator.getPIDController().setD(kD);
  }

  /**
  * Set the elevator's speed
  * @param speed from -1 to 1
  */
  public void setElevatorSpeed(double speed) {
    Elevator.getPIDController().setReference(speed, ControlType.kDutyCycle);
  }

  /**
   * Returns the position of the encoder
   * @return double elevator encoder position 
   */
  public double getElevatorEncoder() {
    return Elevator.getEncoder().getPosition() - encoderOffset;
  }

  /**
   * Resets the encoder by subtracting the current value as an offset, but only when the limit switch is hit 
   */
  public void resetElevatorEncoder(){
    if(RobotMap.elevatorBottomLimit.get() == true)
      encoderOffset = Elevator.getEncoder().getPosition();
  }
  /** 
   * Gets the Elevator limitswitch value
  */
  public boolean getElevatorLimitSwitch(){
    return RobotMap.elevatorBottomLimit.get();
  }

  /**
   * Sets the elevator position 
   * @param position //TODO don't know whether to make this in inches, encoder ticks, or RPM
   */
  public void setElevatorPosition(int value){
    Elevator.getPIDController().setReference(value, ControlType.kPosition);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
