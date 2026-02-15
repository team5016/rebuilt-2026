// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AgitatorSpin;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.Intake.IntakeCollector;
import frc.robot.subsystems.Intake.ExtendableHopper;
import frc.robot.subsystems.Shooter.Agitator;
import frc.robot.subsystems.Shooter.Feeder;
import frc.robot.subsystems.Shooter.FlywheelShooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  // Subsystems
  private final Swerve swerveDrivetrain = new Swerve();
  private final IntakeCollector intakeCollector = new IntakeCollector();
  private final ExtendableHopper intakeHopper = new ExtendableHopper();
  private final Agitator agitator = new Agitator();
  private final Feeder shooterFeeder = new Feeder();
  private final FlywheelShooter shooter = new FlywheelShooter();

  // Commands
  private final AgitatorSpin agit = new AgitatorSpin(agitator);

  private final CommandXboxController driverController =
    new CommandXboxController(OperatorConstants.DriverControllerPort);
  private final CommandXboxController operatorController =
    new CommandXboxController(OperatorConstants.OperatorControllerPort);

  /* Path follower */
  //private final SendableChooser<Command> autoChooser;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    registerNamedCommands();
    //autoChooser = AutoBuilder.buildAutoChooser("<<<CHANGE NAME>>>");

    configureBindings();

    // Add camera feed to dashboard
    CameraServer.startAutomaticCapture();
  }

  private void registerNamedCommands() {
    // NamedCommands.registerCommand(...);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_exampleSubsystem::exampleCondition).onTrue(
    //   new ExampleCommand(m_exampleSubsystem)
    // );

    // // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // // cancelling on release.
    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    configureDriveBindings();
        configureGameplayBindings();
      }
    
  private void configureDriveBindings() {
    swerveDrivetrain.configureBindings(driverController);
  }
    
  private void configureGameplayBindings() {
    operatorController.b().onTrue(intakeCollector.run());
    operatorController.a().onTrue(shooter.shoot());
    operatorController.x().onTrue(agitator.shakeIt());
    operatorController.y().onTrue(shooterFeeder.feed());
    operatorController.rightTrigger().onTrue(intakeHopper.toggleExtend());


    operatorController.rightBumper()
      .onTrue(shooter.shoot().andThen(shooterFeeder.feed()))
      .onFalse(shooter.stop().alongWith(shooterFeeder.stop()));
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    //return autoChooser.getSelected();
    return Commands.none();
  }
}
