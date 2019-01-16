package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

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

        leftDriveMaster.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
        rightDriveMaster.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
        leftDriveMaster.setSensorPhase(false);
        rightDriveMaster.setSensorPhase(false);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
      }

    public void setToPositionMode(){
        leftDriveMaster.set(ControlMode.Position, 0);
        rightDriveMaster.set(ControlMode.Position, 0);
    }
    public void setToPercentValue(){
        leftDriveMaster.set(ControlMode.PercentOutput, 1);
        rightDriveMaster.set(ControlMode.PercentOutput, 1);
    }

    public int getRightEncoder(){
        return rightDriveMaster.getSensorCollection().getQuadraturePosition() / 2;
    }

    public int getLeftEncoder(){
        return rightDriveMaster.getSensorCollection().getQuadraturePosition() / 2;
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
        leftDriveMaster.getSensorCollection().setQuadraturePosition(0, 0);
    }

    public void resetRightEncoder(){
        rightDriveMaster.getSensorCollection().setQuadraturePosition(0, 0);
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
        leftDriveMaster.set(-stick.getRawAxis(1));
        rightDriveMaster.set(stick.getRawAxis(1));
    }
}