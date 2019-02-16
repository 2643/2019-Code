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

/**
 * Add your docs here.
 */
public class Hatch extends Subsystem {
  DoubleSolenoid hatchPiston1;
  DoubleSolenoid hatchPiston2;
  DoubleSolenoid releaseHatchPiston1;
  DoubleSolenoid releaseHatchPiston2;

    public Hatch(DoubleSolenoid HatchSolenoid, DoubleSolenoid HatchSolenoid2, DoubleSolenoid HatchSolenoid3, DoubleSolenoid HatchSolenoid4){
        HatchSolenoid = hatchPiston1;
        HatchSolenoid2 = hatchPiston2;
        HatchSolenoid3 = releaseHatchPiston1;
        HatchSolenoid4 = releaseHatchPiston2;
    }
 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  /**
   * This function will pull the hatch mechanism in.
   */
  public void mechanismPistonIn(){
    hatchPiston1.set(DoubleSolenoid.Value.kReverse);
    hatchPiston2.set(DoubleSolenoid.Value.kReverse);
  }
  /**
   * This function will push the hatch mechanism out.
   */
  public void mechanismPistonOut(){
    hatchPiston1.set(DoubleSolenoid.Value.kForward);
    hatchPiston2.set(DoubleSolenoid.Value.kForward);
  }

  /**
   * This function turn the hatch mechanism off
   */
  public void mechanismPistonOff(){
    hatchPiston1.set(DoubleSolenoid.Value.kOff);
  }

  /**
   * Moves hatch pistons in
   */
  public void hatchPistonIn(){
    releaseHatchPiston1.set(DoubleSolenoid.Value.kReverse);
    releaseHatchPiston2.set(DoubleSolenoid.Value.kReverse);
  }
  /**
   * Moves hatch pistons out
   */
  public void hatchPistonOut(){
    releaseHatchPiston1.set(DoubleSolenoid.Value.kForward);
    releaseHatchPiston2.set(DoubleSolenoid.Value.kForward);
  }

  /**
   * Turns the hatch pistons out
   */
  public void hatchPistonOff(){
    releaseHatchPiston1.set(DoubleSolenoid.Value.kOff);
    releaseHatchPiston2.set(DoubleSolenoid.Value.kOff);
  }
  /**
   * Gets the hatch timer
   */
  public Timer getTimer() {
  	return RobotMap.hatchPistonTimer;
  }
}
