package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;

public class Drive extends Subsystem
{
    //Declaring Drive Masters and Slaves
    private final WPI_TalonSRX leftDriveMaster;
    private final WPI_TalonSRX leftDriveSlave;
    private final WPI_TalonSRX rightDriveMaster;
    private final WPI_TalonSRX rightDriveSlave;
    /**
     * Drive constructor 
     * @param l1 left front motor
     * @param l2 left back motor
     * @param r1 right front motor
     * @param r2 right back motor 
     */
    public Drive(WPI_TalonSRX l1, WPI_TalonSRX l2, WPI_TalonSRX r1, WPI_TalonSRX r2){
        leftDriveMaster = l1;
        leftDriveSlave = l2;

        leftDriveSlave.set(ControlMode.Follower, leftDriveMaster.getDeviceID());  

        rightDriveMaster = r1;
        rightDriveSlave = r2;

        rightDriveSlave.set(ControlMode.Follower, rightDriveMaster.getDeviceID());
    }
    /**
     * Sets TankDrive to default command
     */
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    /**
     * Gets Right Encoder
     */
    public int getRightEncoder(){
        return RobotMap.rEncoder.get();
    }
    /**
     * Gets Left Encoder
     */
    public int getLeftEncoder(){
        return RobotMap.lEncoder.get();
    }
    /**
     * Gets the average value of the right and left encoders
     */
    public int getAverageEncoder(){
        return (getRightEncoder() + getLeftEncoder()) / 2;
    }
    /**
     * Finds highest value of encoders
     * @return Highest value of the two
     */
    public int getMaxEncoder(){
        return Math.max(getRightEncoder(), getLeftEncoder());
    }
    /**
     * Finds lowest value of encoders
     * @return Lowest value of the two
     */
    public int getMinEncoder(){
        return Math.min(getRightEncoder(), getLeftEncoder());
    }
    /**
     * Resets left encoder
     */
    public void resetLeftEncoder(){
        RobotMap.lEncoder.reset();
    }
    /**
     * Resets right Encoder
     */
    public void resetRightEncoder(){
        RobotMap.rEncoder.reset();
    }
    /**
     * Resets all encoders
     */
    public void resetAllEncoders(){
        resetLeftEncoder();
        resetRightEncoder();
    }
    /**
     * Sets speed for the left side
     * @param speed
     */
    public void setLeftSpeed(double speed){
        leftDriveMaster.set(-speed); 
    }
    /**
     * Sets speed for right side
     * @param speed
     */
    public void setRightSpeed(double speed){
        rightDriveMaster.set(speed);
    }
    /**
     * Sets speed for both sides
     */
    public void setAllSpeed(double speed){
        setLeftSpeed(speed);
        setRightSpeed(speed);
    }
    /**
     * Stops all the speed
     */
    public void stopAllSpeed(){
        setAllSpeed(0);
    }
}