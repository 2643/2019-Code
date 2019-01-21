/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class Hatch extends Subsystem {
  DoubleSolenoid HatchSolenoid;
  DoubleSolenoid HatchSolenoid2;
  WPI_TalonSRX hatchMotor;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
    public Hatch(DoubleSolenoid hatchPiston1, DoubleSolenoid hatchPiston2, WPI_TalonSRX hatchM){
        HatchSolenoid = hatchPiston1;
        HatchSolenoid2 = hatchPiston2;
        hatchMotor = hatchM;
    }
 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  /**
   * This function will pull the hatch piston in.
   */
  public void pistonIn(){
    HatchSolenoid.set(DoubleSolenoid.Value.kReverse);// This will pull the piston in.
    HatchSolenoid2.set(DoubleSolenoid.Value.kReverse);
  }
  /**
   * This function will push the hatch piston out.
   */
  public void pistonOut(){
    HatchSolenoid.set(DoubleSolenoid.Value.kForward);// This will push the piston out.
    HatchSolenoid2.set(DoubleSolenoid.Value.kForward);
  }
  /**
   * This sets the grabber to a speed
   * @param speed the speed to set the motor from -1 to 1
   */
  public void setMotorSpeed(double speed){
    hatchMotor.set(speed);
  }

  /**
   * Sends the status of the top limit switch on the hatch mechanism
   */
  public boolean getTopLimit(){
    return RobotMap.HatchTopSwitch.get();
  }

  /**
   * Sends the status of the bottom limit switch on the hatch mechanism
   */
  public boolean getBottomLimit(){
    return RobotMap.HatchBottomSwitch.get();
  }

  /**
   * Returns the value of the timer used to determine
   */
  public Timer getTimer(){
    return RobotMap.hatchPistonTimer;
  }
}
