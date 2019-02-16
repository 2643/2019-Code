package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class HatchAutoAlign extends Command {

    boolean finished = true;

    public HatchAutoAlign () {
        requires(Robot.drive);
        requires(Robot.hatch);
    }

    @Override
    protected void execute() {
        double centerLocation = (RobotMap.visionTable.getEntry("centroid-left-x").getDouble(0)
                + RobotMap.visionTable.getEntry("centroid-right-x").getDouble(0)) / 2;
        boolean valid = RobotMap.visionTable.getEntry("valid").getBoolean(false);
        System.out.println("valid: " + valid + "center: " + centerLocation);
        if (valid) {
            if (centerLocation > 0.1) {
                Robot.drive.setAllSpeed(0.3, -0.3);
            } else if (centerLocation < -0.1) {
                Robot.drive.setAllSpeed(-0.3, 0.3);
            } else {
                Robot.drive.setAllSpeed(0.3, 0.3);
            }
        } else {
            Robot.drive.setAllSpeed(0, 0);
        }
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        Robot.drive.setAllSpeed(0, 0);
    }

    @Override
    protected boolean isFinished() {
        Robot.drive.isStuck();
    }

}