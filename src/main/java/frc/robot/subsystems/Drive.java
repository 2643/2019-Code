package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;

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
    }

    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    //this is kind of useless if there is no encoder plugged into it 
    public void setToPositionMode(int encoderTicks){
        leftDriveMaster.set(ControlMode.Position, encoderTicks);
        rightDriveMaster.set(ControlMode.Position, encoderTicks);
    }

    public void setToPercentValue(double speed){ //this is supposed to change 
        leftDriveMaster.set(ControlMode.PercentOutput, speed); 
        rightDriveMaster.set(ControlMode.PercentOutput, speed);
    }

    public int getRightEncoder(){
        return RobotMap.rEncoder.get();
    }

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
}