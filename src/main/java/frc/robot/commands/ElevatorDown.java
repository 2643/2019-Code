  /*----------------------------------------------------------------------------*/
  /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
  /* Open Source Software - may be modified and shared by FRC teams. The code   */
  /* must be accompanied by the FIRST BSD license file in the root directory of */
  /* the project.                                                               */
  /*----------------------------------------------------------------------------*/

  package frc.robot.commands;

  import edu.wpi.first.wpilibj.command.Command;
  import frc.robot.Robot;
  import frc.robot.RobotMap;
  /**
   * Moves elevator down
   */
  public class ElevatorDown extends Command {
    public ElevatorDown() {
      requires(Robot.elevator);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
      if(Robot.elevator.getElevatorBottomLimitSwitch()){
        Robot.elevator.setElevatorSpeed(0);
      }
      else{
        Robot.elevator.setElevatorSpeed(-RobotMap.elevatorSpeed-0.2);
      }
    }

    @Override
    protected boolean isFinished() {
      /* Check if the Bottom Limit has been tripped
      *  if it has, stop, and reset encoder, else continue
      */
      if(RobotMap.elevatorBottomLimit.get()) {
        return true;
      }
      else {
        return false;
      }
    }

    @Override
    protected void end() {
      Robot.elevator.setElevatorSpeed(0);
     
      if (Robot.elevator.getElevatorBottomLimitSwitch()) {
        Robot.elevator.stopElevatorPID();
      }
      else {
        Robot.elevator.setElevatorPosition(Robot.elevator.getElevatorEncoder());
      }
    }

    @Override
    protected void interrupted() {
      if(!Robot.oi.getDriverStick().getRawButton(RobotMap.elevatorDownButtonNumber)){
        end();
      }
    }
  }
