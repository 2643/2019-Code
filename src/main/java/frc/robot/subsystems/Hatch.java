/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


/**
 * Add your docs here.
 */
public class Hatch extends Subsystem {
  DoubleSolenoid HatchSolenoid;
  DoubleSolenoid HatchSolenoid2;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
    public Hatch(DoubleSolenoid hatchPiston){
        HatchSolenoid = hatchPiston;
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
   * This moves the grabber down to pick up the hatch panel.
   */
  public void moveDown(){
  }
  /**
   * This moves the grabber back up.
   */
  public void moveUp(){

  }
}
