/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;
import frc.robot.RobotMap;

// import com.revrobotics.ControlType;

import edu.wpi.cscore.VideoSource;

  /**
   * The VM is configured to automatically run this class, and to call the
   * functions corresponding to each mode, as described in the TimedRobot
   * documentation. If you change the name of this class or the package after
   * creating this project, you must also update the build.gradle file in the
   * project.
   */
  public class Robot extends TimedRobot {
    public static OI oi;
    public static Hatch hatch = new Hatch(RobotMap.hatchMechanismSolenoid, RobotMap.releaseHatchSolenoid);
    public static Elevator elevator = new Elevator(RobotMap.elevatorMotor);
    public static Drive drive = new Drive(RobotMap.LeftFrontMotor, RobotMap.LeftBackMotor, RobotMap.RightFrontMotor, RobotMap.RightBackMotor);
    public static DriverCamera driverCameras = new DriverCamera(RobotMap.frontCamera);
    public static CargoIntake cargoIntake = new CargoIntake(RobotMap.cargoIntakeMotor1, RobotMap.cargoIntakeMotor2, RobotMap.cargoRetractMotor);
    public static CargoOuttake cargoOuttake = new CargoOuttake(RobotMap.cargoOuttakeMotor);
    public static Gyroscope gyroscope = new Gyroscope();
    public static LineDetector lineDetector = new LineDetector();

    public static boolean CalibrateSparkMax = false;
    public static int CalibrateNumber;
    public static boolean atBottom = false; 
  
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
      oi = new OI();
      
      gyroscope.setGyroDeclination();

      RobotMap.ultrasonicLeftOne.setAutomaticMode(true);
      
      RobotMap.curCargoAutoState = RobotMap.cargoAutoState.IDLE;
      RobotMap.curCargoAutoSide = RobotMap.cargoAutoSide.NONE;

      RobotMap.curIRStateLeftOne = RobotMap.IRState.IDLE;
      RobotMap.curIRStateLeftTwo = RobotMap.IRState.IDLE;
      RobotMap.curIRStateLeftThree = RobotMap.IRState.IDLE;
      RobotMap.curIRStateRightOne = RobotMap.IRState.IDLE;
      RobotMap.curIRStateRightTwo = RobotMap.IRState.IDLE;
      RobotMap.curIRStateRightThree = RobotMap.IRState.IDLE;

      RobotMap.frontCamera.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
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
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    /* --
    //This is commented out because the elevator become unoperational after Govind broke it
    //It should be uncommented when the elevator is fixed mechanically

    // if(RobotMap.elevatorBottomLimit.get() && !atBottom && !CalibrateSparkMax){
        //This reduces the amount of times that this piece of code runs
    //   if(CalibrateNumber % 5 == 0){
    //     RobotMap.rotations = RobotMap.elevatorMotor.getEncoder().getPosition() - 2;
    //     RobotMap.elevatorMotor.getPIDController().setReference(RobotMap.rotations, ControlType.kPosition);
    //   }
    // }
    // else if(!RobotMap.elevatorBottomLimit.get() && !CalibrateSparkMax){
    //   atBottom = true;
    // }
    // else if(!CalibrateSparkMax){
    //     CalibrateNumber ++;
    //     if(RobotMap.elevatorBottomLimit.get()){
    //       if(CalibrateNumber % 25 == 0){
    //         RobotMap.rotations = (RobotMap.elevatorMotor.getEncoder().getPosition() - 1);
    //         RobotMap.elevatorMotor.getPIDController().setReference(RobotMap.rotations, ControlType.kPosition);
    //         System.out.println("Moving up");
    //       }
    //     }else if(!RobotMap.elevatorBottomLimit.get()){
    //         RobotMap.rotations = 0;
    //         RobotMap.elevatorMotor.getEncoder().setPosition(0);
    //         CalibrateSparkMax = true;
    //         System.out.println("Zeroed");
    //     }
    //   }else{
    //    Scheduler.getInstance().run();
    //    System.out.println(RobotMap.elevatorMotor.getEncoder().getPosition());
    //   }
    */
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
      
    }
  }
