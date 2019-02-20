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
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;

  /**
   * Setting Motors
   * @param liftMotor elevator motor
   */
  public Elevator(CANSparkMax liftMotor) {
    Elevator = liftMotor;

    Elevator.getPIDController().setP(kP);
    Elevator.getPIDController().setI(kI);
    Elevator.getPIDController().setD(kD);
    // PID coefficients
    kP = 0.1; 
    kI = 1e-4;
    kD = 1; 
    kIz = 0; 
    kFF = 0; 
    kMaxOutput = .5; 
    kMinOutput = -.5;
    
    // set PID coefficients
    RobotMap.elevatorController.setP(kP);
    RobotMap.elevatorController.setI(kI);
    RobotMap.elevatorController.setD(kD);
    RobotMap.elevatorController.setIZone(kIz);
    RobotMap.elevatorController.setFF(kFF);
    RobotMap.elevatorController.setOutputRange(kMinOutput, kMaxOutput);

  }

  /**
  * Set the elevator's speed
  * @param speed from -1 to 1
  */
  public void setElevatorSpeed(double speed) {
    Elevator.set(speed);
  }

  /**
   * Returns the position of the encoder
   * @return double elevator encoder position 
   */
  public double getElevatorEncoder() {
    return(Elevator.getEncoder().getPosition() - encoderOffset);
  }

  /**
   * Resets the encoder by subtracting the current value as an offset, but only when the limit switch is hit 
   */
  public void resetElevatorEncoder(){
    if(getElevatorLimitSwitch()) {
      encoderOffset = Elevator.getEncoder().getPosition();
    }
  }
  /** 
   * Gets the Elevator limitswitch value
  */
  public boolean getElevatorLimitSwitch(){
    return(RobotMap.elevatorBottomLimit.get());
  }

  /**
   * Sets the elevator position 
   * @param position //TODO don't know whether to make this in encoder ticks, or RPM
   */
  public void setElevatorPosition(int value){
    //Elevator.getPIDController().setReference(value, ControlType.kPosition);
     // read PID coefficients from SmartDashboard
     double p = 0.065;
     double i = 0.005;
     double d = 0;
     double iz = 0;
     double ff = 0;
     double max = 0.5;
     double min = -0.5;
     double rotations = 0;
 
     // if PID coefficients on SmartDashboard have changed, write new values to controller
     if((p != kP)) { RobotMap.elevatorController.setP(p); kP = p; }
     if((i != kI)) { RobotMap.elevatorController.setI(i); kI = i; }
     if((d != kD)) { RobotMap.elevatorController.setD(d); kD = d; }
     if((iz != kIz)) { RobotMap.elevatorController.setIZone(iz); kIz = iz; }
     if((ff != kFF)) { RobotMap.elevatorController.setFF(ff); kFF = ff; }
     if((max != kMaxOutput) || (min != kMinOutput)) { 
      RobotMap.elevatorController.setOutputRange(min, max); 
       kMinOutput = min; kMaxOutput = max; 
     }
 
     /**
      * PIDController objects are commanded to a set point using the 
      * SetReference() method.
      * 
      * 
      * The first parameter is the value of the set point, whose units vary
      * depending on the control type set in the second parameter.
      * 
      * The second parameter is the control type can be set to one of four 
      * parameters:
      *  com.revrobotics.ControlType.kDutyCycle
      *  com.revrobotics.ControlType.kPosition
      *  com.revrobotics.ControlType.kVelocity
      *  com.revrobotics.ControlType.kVoltage
      */
      RobotMap.elevatorController.setReference(rotations, ControlType.kPosition);
     

  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
