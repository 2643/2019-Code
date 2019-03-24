package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class HatchAuto extends CommandGroup {
  public HatchAuto() {
    addSequential(new ElevatorDown());
  }
}
