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
  private CANSparkMax elevatorMotor;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;

  /**
   * Setting Motors
   * @param liftMotor elevator motor
   */
  public Elevator(CANSparkMax liftMotor) {
    elevatorMotor = liftMotor;

    elevatorMotor.getPIDController().setP(kP);
    elevatorMotor.getPIDController().setI(kI);
    elevatorMotor.getPIDController().setD(kD);
    // PID coefficients
    kP = 0.011; 
    kI = 0;
    kD = 0; 
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
    //elevatorMotor.getPIDController().setReference(speed, ControlType.kDutyCycle);

    elevatorMotor.set(speed);
    System.out.println("Ele Speed: " + speed);
  }

  /**
   * Returns the position of the encoder
   * @return double elevator encoder position 
   */
  public double getElevatorEncoder() {
    return(elevatorMotor.getEncoder().getPosition());
  }

  /**
   * Resets the encoder by subtracting the current value as an offset, but only when the limit switch is hit 
   */
  public void resetElevatorEncoder(){
    if(getElevatorBottomLimitSwitch()) {
      elevatorMotor.getEncoder().setPosition(0);
    }
  }
  /** 
   * Gets the value of the bottom limit switch
   * @return boolean
  */
  public boolean getElevatorBottomLimitSwitch(){
    return(RobotMap.elevatorBottomLimit.get());
  }

  /**
   * Gets the value of the upper limit switch 
   * @return boolean
   */
  public boolean getElevatorUpperLimitSwitch(){
    return (RobotMap.elevatorUpperLimit.get());
  }
  
  /**
   * Sets the elevator position 
   * @param position in rotations
   */
  public void setElevatorPosition(double rotation){
     // read PID coefficients from SmartDashboard
     double p = 0.03; //06 04 02
     double i = 0.0015;
     double d = 0.15; //18\
     double iz = 0.0;
     double ff = 0.0;
     double max = 0.6;
     double min = -0.6;
     double rotations = rotation;
 
     // if PID coefficients on SmartDashboard have changed, write new values to controller
     if((p != kP)) { elevatorMotor.getPIDController().setP(p); kP = p; }
     if((i != kI)) { elevatorMotor.getPIDController().setI(i); kI = i; }
     if((d != kD)) { elevatorMotor.getPIDController().setD(d); kD = d; }
     if((iz != kIz)) { elevatorMotor.getPIDController().setIZone(iz); kIz = iz; }
     if((ff != kFF)) { elevatorMotor.getPIDController().setFF(ff); kFF = ff; }
     if((max != kMaxOutput) || (min != kMinOutput)) { 
      elevatorMotor.getPIDController().setOutputRange(min, max); 
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
      elevatorMotor.getPIDController().setReference(rotations, ControlType.kPosition);
     

  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
