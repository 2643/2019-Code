/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 * Add your docs here.
 */
public class Hatch extends Subsystem {
  DoubleSolenoid hatchMechanismSolenoid;
  DoubleSolenoid releaseHatchSolenoid;

  public Hatch(DoubleSolenoid HatchMechanismSolenoid, DoubleSolenoid ReleaseHatchSolenoid){
    hatchMechanismSolenoid = HatchMechanismSolenoid;
    releaseHatchSolenoid = ReleaseHatchSolenoid;
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
    hatchMechanismSolenoid.set(DoubleSolenoid.Value.kForward);
  }
  /**
   * This function will push the hatch mechanism out.
   */
  public void mechanismPistonOut(){
    hatchMechanismSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  /**
   * This function turn the hatch mechanism off
   */
  public void mechanismPistonOff(){
    hatchMechanismSolenoid.set(DoubleSolenoid.Value.kOff);
  }

  /**
   * Moves hatch pistons in
   */
  public void hatchPistonIn(){
    releaseHatchSolenoid.set(DoubleSolenoid.Value.kForward);
  }
  /**
   * Moves hatch pistons out
   */
  public void hatchPistonOut(){
    releaseHatchSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  /**
   * Turns the hatch pistons out
   */
  public void hatchPistonOff(){
    releaseHatchSolenoid.set(DoubleSolenoid.Value.kOff);
  }
}
