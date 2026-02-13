package frc.robot.commands;
import frc.robot.subsystems.Feeder.Intake;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class IntakeSpin extends Command {
  @SuppressWarnings("PMD.UnusedPrivateField")
    private final Intake H_op;
    private final int speed;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakeSpin(Intake subsystem, int S) {
    H_op = subsystem;
    speed = S;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    H_op.getMotor1().set(speed);
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    H_op.getMotor1().set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}


