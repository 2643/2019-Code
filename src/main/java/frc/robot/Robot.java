/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;
import frc.robot.RobotMap;
import edu.wpi.cscore.VideoSource;d

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI oi;
  public static Hatch hatch = new Hatch(RobotMap.HatchPiston, RobotMap.HatchPiston2, RobotMap.ReleaseHatchPiston1, RobotMap.ReleaseHatchPiston2);
  public static Elevator elevator = new Elevator(RobotMap.elevatorMotor, RobotMap.elevatorSlaveMotor);
  public static Drive drive = new Drive(RobotMap.lFrontMotor, RobotMap.lBackMotor, RobotMap.rFrontMotor, RobotMap.rBackMotor);
  public static Carriage carriage = new Carriage(RobotMap.carriageMotor);
  public static CargoIntake cargoIntake = new CargoIntake(RobotMap.cargoIntakeMotor1, RobotMap.cargoIntakeMotor2, RobotMap.cargoRetractMotor);
  public static CargoOuttake cargoOuttake = new CargoOuttake(RobotMap.cargoOuttakeMotor);
  public static Gyroscope gyroscope = new Gyroscope(RobotMap.gyro);
  public static LineDetector lineDetector = new LineDetector();
  
  //Command m_autonomousCommand;
  //SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    oi = new OI();

    RobotMap.ultrasonicLeftOne.setAutomaticMode(false);

    boolean ultrasonicPingWhichInit = true;
    int ultrasonicPingInit = 0;

    // chooser.addOption("My Auto", new MyAutoCommand());
    //SmartDashboard.putData("Auto mode", m_chooser);

    RobotMap.camera1 = CameraServer.getInstance().startAutomaticCapture(0);
    RobotMap.camera2 = CameraServer.getInstance().startAutomaticCapture(1);
    RobotMap.server = CameraServer.getInstance().getServer();

    RobotMap.camera1.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    RobotMap.camera2.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    //m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    //if (m_autonomousCommand != null) {
    //  m_autonomousCommand.start();
    //}
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    
    //if (m_autonomousCommand != null) {
    //  m_autonomousCommand.cancel();
    //}
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    drive.setAllSpeed(0.3);
    if(oi.getDriverStick().getRawButton(1) == true)
      drive.setLeftSpeed(0.3);
    else if(oi.getDriverStick().getRawButton(2) == true)
      drive.setRightSpeed(0.3);
    else if(oi.getDriverStick().getRawButton(3) == true)
      drive.setAllSpeed(0.3);
    else
      drive.setAllSpeed(0);
  }
}
