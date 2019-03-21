/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.*;
/**
 * Releases the hatch panel
 */
public class ReleaseHatch extends Command {

  Timer hatchTimer = new Timer();

  public ReleaseHatch() {
    requires(Robot.hatch);
  }

  @Override
  protected void initialize() {
    hatchTimer.reset();
    hatchTimer.start();
  }

  @Override
  protected void execute() { 
    if(hatchTimer.get() <= 1){
      Robot.hatch.hatchPistonOut();
    }else if(hatchTimer.get() <= 2 && hatchTimer.get() > 1){

    }else if(hatchTimer.get() >= 3){
      Robot.hatch.hatchPistonIn();
    }
  }

  @Override
  protected boolean isFinished() {
    if(hatchTimer.get() >= RobotMap.hatchReleaseTimeout) {
      return(true);
    }
    else{
      return(false);
    }
  }

  @Override
  protected void end() {
    Robot.hatch.hatchPistonIn();
    hatchTimer.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
