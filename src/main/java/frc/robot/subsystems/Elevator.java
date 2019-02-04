/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private CANSparkMax Elevator;
  private CANEncoder ElevatorEncoder;
  /**
   * Setting Motors
   * @param liftMotor Lift Motor
   * @param slaveMotor Follower Motor
   */
  public Elevator(CANSparkMax liftMotor, CANEncoder encoder) {
    Elevator = liftMotor;
    ElevatorEncoder = encoder;
  }

  // Set elevator's speed
  /**
  * Set the elevator's speed
  * @return
  */
  public void setElevatorSpeed(double speed) {
    Elevator.set(speed);
  }

  // Returns the postition of the encoder
  // TODO check whether we need to divide it by 2 or not. Last year had a problem with it.

  /**
   * Gets the elevator encoder value
   */
  public double getElevatorEncoder() {
    return ElevatorEncoder.getPosition();
  }


  /** 
   * Gets the Elevator limitswitch value
  */
  public boolean getElevatorLimitSwitch(){
    return RobotMap.elevatorBottomLimit.get();
  }

  /**
   * TODO for SparkMax
   */
  public void setElevatorPosition(int positionInInches){
    RobotMap.elevatorMotor.set(ControlMode.Position, positionInInches);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
