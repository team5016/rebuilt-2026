package frc.robot.commands;

import frc.robot.subsystems.Intake.Index;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class IndexCom extends Command {
  @SuppressWarnings("PMD.UnusedPrivateField")
  private final Index IndexMotor;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IndexCom(Index subsystem) {
    IndexMotor = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    IndexMotor.getMotor1().set(0.5);
  }
    // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    IndexMotor.getMotor1().set(0);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
