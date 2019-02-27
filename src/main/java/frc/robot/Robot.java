package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;
import frc.robot.RobotMap;
import edu.wpi.cscore.VideoSource;

public class Robot extends TimedRobot {
  public static OI oi;
  public static Hatch hatch = new Hatch(RobotMap.HatchPiston, RobotMap.HatchPiston2, RobotMap.ReleaseHatchPiston1, RobotMap.ReleaseHatchPiston2);
  public static Elevator elevator = new Elevator(RobotMap.elevatorMotor);
  public static Drive drive = new Drive(RobotMap.LeftFrontMotor, RobotMap.LeftBackMotor, RobotMap.RightFrontMotor, RobotMap.RightBackMotor);
  public static DriverCamera driverCameras = new DriverCamera(RobotMap.leftDriverCameraServo, RobotMap.rightDriverCameraServo, RobotMap.leftCamera, RobotMap.rightCamera);
  public static CargoIntake cargoIntake = new CargoIntake(RobotMap.cargoIntakeMotor1, RobotMap.cargoIntakeMotor2, RobotMap.cargoRetractMotor);
  public static CargoOuttake cargoOuttake = new CargoOuttake(RobotMap.cargoOuttakeMotor);
  // ++ public static Gyroscope gyroscope = new Gyroscope(RobotMap.gyro);
  public static LineDetector lineDetector = new LineDetector();
  public static UltrasonicSystem ultrasonicSystem = new UltrasonicSystem();
 
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    oi = new OI();

    elevator.resetElevatorEncoder(); //Needs to be at the bottom, hitting the limit switch.
    RobotMap.ultrasonicLeftOne.setAutomaticMode(true);

    RobotMap.curIRStateLeftOne = RobotMap.IRState.IDLE;
    RobotMap.curIRStateLeftTwo = RobotMap.IRState.IDLE;
    RobotMap.curIRStateLeftThree = RobotMap.IRState.IDLE;
    RobotMap.curIRStateRightOne = RobotMap.IRState.IDLE;
    RobotMap.curIRStateRightTwo = RobotMap.IRState.IDLE;
    RobotMap.curIRStateRightThree = RobotMap.IRState.IDLE;

    RobotMap.leftCamera = CameraServer.getInstance().startAutomaticCapture(0);
    RobotMap.rightCamera = CameraServer.getInstance().startAutomaticCapture(1);
    RobotMap.server = CameraServer.getInstance().getServer();

    //TODO Sanjana: Set default camera source and direction
    RobotMap.leftCamera.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    RobotMap.rightCamera.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
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
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }
  public static void pause(int millis) {
    try {
      Thread.sleep(millis);
    } catch(InterruptedException ie) {
      System.err.println("whoops! sleep interrupted!");
    }
  }
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    if(oi.getOperatorBoard().getRawButton(RobotMap.elevatorUpButtonNumber)){
      RobotMap.elevatorMotor.set(-0.5);
      System.out.println("Current: " + RobotMap.elevatorMotor.getOutputCurrent());
      System.out.println("Encoder: " + RobotMap.elevatorMotor.getEncoder());
      System.out.println("Elevator Up");
    }else if(oi.getOperatorBoard().getRawButton(RobotMap.elevatorDownButtonNumber)){
      RobotMap.elevatorMotor.set(0.5);
      System.out.println("Encoder: " + RobotMap.elevatorMotor.getEncoder());
      System.out.println("Current: " + RobotMap.elevatorMotor.getOutputCurrent());
      System.out.println("Elevator Down");
      System.out.println("Limit Switch: " + RobotMap.elevatorBottomLimit.get());
    }else if(oi.getOperatorBoard().getRawButton(RobotMap.intakeButtonNumber)){
      RobotMap.cargoIntakeMotor1.set(0.3);
      RobotMap.cargoIntakeMotor2.set(0.3);
      System.out.println("Intaking Cargo");
    }else if(oi.getOperatorBoard().getRawButton(8)){
      RobotMap.cargoRetractMotor.set(0.4);
      System.out.println("Retract cargo intake");
    }else if(oi.getOperatorBoard().getRawButton(11)){
      RobotMap.cargoRetractMotor.set(-0.4);
      System.out.println("Extend cargo intake");
    }else if(oi.getOperatorBoard().getRawButton(RobotMap.cargoOuttakeLeftButtonNumber)){
      RobotMap.cargoOuttakeMotor.set(-0.4);
      System.out.println("Cargo outtake left");
    }else if(oi.getOperatorBoard().getRawButton(RobotMap.cargoOuttakeRightButtonNumber)){
      RobotMap.cargoOuttakeMotor.set(0.4);
      System.out.println("Cargo outtake right");
    }/* else if(oi.getDriverStick().getRawButton(1)){
      Robot.hatch.mechanismPistonOut();
      System.out.println("Hatch Mechanism Out:");
    }else if(oi.getDriverStick().getRawButton(4)){
      Robot.hatch.mechanismPistonIn();
      System.out.println("Hatch Mechanism In:");
    else if(oi.getDriverStick().getRawButton(5)){
      Robot.hatch.hatchPistonOut();
      System.out.println("Hatch piston out:");
    }else if(oi.getDriverStick().getRawButton(6)){
      Robot.hatch.hatchPistonIn();
      System.out.println("Hatch piston in:");
    }*/

    // if(oi.driverStick.getPOV() == 0){
    //   Robot.driverCameras.setRightServoAngle(RobotMap.forwardAngle);
    //   Robot.driverCameras.setCameraSource(RobotMap.rightCamera);
    // }else if(oi.driverStick.getPOV() == 90){
    //   Robot.driverCameras.setRightServoAngle(RobotMap.rightAngle);
    //   Robot.driverCameras.setCameraSource(RobotMap.rightCamera);
    // }else if(oi.driverStick.getPOV() == 180){  
    //   Robot.driverCameras.setLeftServoAngle(RobotMap.backwardAngle);
    //   Robot.driverCameras.setCameraSource(RobotMap.leftCamera);
    // }else if(oi.driverStick.getPOV() == 270){
    //   Robot.driverCameras.setLeftServoAngle(RobotMap.leftAngle);
    //   Robot.driverCameras.setCameraSource(RobotMap.leftCamera);
    // }

    RobotMap.leftDriverCameraServo.setAngle(180);
    RobotMap.rightDriverCameraServo.setAngle(180);


  }
}
