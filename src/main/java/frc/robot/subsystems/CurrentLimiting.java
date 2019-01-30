/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * This is the Power Distribution Panel that handles all of the electronics on the robot
 */
public class CurrentLimiting extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  PowerDistributionPanel pdp;
  int driveTrainPriority = 3; 
  int elevatorPriority = 3; 
  int carriagePriority = 3;
  int cargoIntakePriority  = 3;
  int cargoOuttakePriority = 3;


  /**
   * Constructor for the Power Distribution Panel 
   * @param PDP power distribution panel
   */
  public CurrentLimiting(PowerDistributionPanel PDP){
    pdp = PDP;
  }

  /**
   * Gets the current from a certain channel on the Power Distribution Panel 
   * @param channel channel on the Power Distribution Panel 
   * NOT THE SAME AS THE ROBORIO PORT 
   */
  public double getCurrent(int channel) {
    return pdp.getCurrent(channel); 

  }

  /**
   * Gets the total current from the robot
   * @return double total current from all channels
   */
  public double getTotalCurrent(){
    return pdp.getTotalCurrent();
  }
  
  /**
   * Gets the total battery voltage 
   * @return double battery voltage
   */
  public double getBatteryVoltage(){
    return pdp.getVoltage();
  }

  /**
   * Gets the total power 
   * @return double total power
   */
  public double getTotalPower(){
    return pdp.getTotalPower();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
