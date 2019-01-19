package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Elevator;

public class Drive extends Subsystem
{
    private final WPI_TalonSRX leftDriveMaster;
    private final WPI_TalonSRX leftDriveSlave;
    private final WPI_TalonSRX rightDriveMaster;
    private final WPI_TalonSRX rightDriveSlave;

    public Drive(WPI_TalonSRX l1, WPI_TalonSRX l2, WPI_TalonSRX r1, WPI_TalonSRX r2){
        leftDriveMaster = l1;
        leftDriveSlave = l2;

        leftDriveSlave.set(ControlMode.Follower, leftDriveMaster.getDeviceID());

        rightDriveMaster = r1;
        rightDriveSlave = r2;

        rightDriveSlave.set(ControlMode.Follower, rightDriveMaster.getDeviceID());

        //currentLimit(leftDriveMaster);
        //currentLimit(rightDriveMaster);


    }

    //you need to make a command called tank drive for it to be the default command for this subsystem
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
      }

    public void setToPositionMode(int encoderTicks){             //this is supposed to be an encoder value
                                                 //supposed to change
        leftDriveMaster.set(ControlMode.Position, encoderTicks);
        rightDriveMaster.set(ControlMode.Position, encoderTicks);
    }
    public void setToPercentValue(double speed){
                                                      //this is supposed to change 
        leftDriveMaster.set(ControlMode.PercentOutput, speed);
        rightDriveMaster.set(ControlMode.PercentOutput, speed);
    }

    //we are not using an encoder that plugs into the TalonSRX
    public int getRightEncoder(){
        return RobotMap.rEncoder.get();
    }

    //we are not using an encoder that plugs into the TalonSRX
    public int getLeftEncoder(){
        return RobotMap.lEncoder.get();
    }

    public int getAverageEncoder(){
        int i = getRightEncoder() + getLeftEncoder();
        return (i / 2);
    }

    public int getMaxEncoder(){
        return Math.max(getRightEncoder(), getLeftEncoder());
    }

    public int getMinEncoder(){
        return Math.min(getRightEncoder(), getLeftEncoder());
    }

    public void resetLeftEncoder(){
        RobotMap.lEncoder.reset();
    }

    public void resetRightEncoder(){
        RobotMap.rEncoder.reset();
    }

    public void resetAllEncoders(){
        resetLeftEncoder();
        resetRightEncoder();
    }

    public void setLeftSpeed(double speed){
        leftDriveMaster.set(-speed);
    }

    public void setRightSpeed(double speed){
        rightDriveMaster.set(speed);
    }

    public void setAllSpeed(double speed){
        setLeftSpeed(speed);
        setRightSpeed(speed);
    }

    public void stopAllSpeed(){
        setAllSpeed(0);
    }

    public void driveWithJoystick(Joystick stick){
        leftDriveMaster.set(-Robot.oi.getDriverStick().getRawAxis(1));
        rightDriveMaster.set(Robot.oi.getOperatorStick().getRawAxis(1));
    }
}