//Tm Bennett/Hunter

package frc.robot.commands;
import frc.robot.subsystems.Feeder.Agitator;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class AgitatorSpin extends Command {
  @SuppressWarnings("PMD.UnusedPrivateField")
    private final Agitator Feeder;
    private final double speed;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AgitatorSpin(Agitator subsystem, double S) {
    Feeder = subsystem;
    speed = S;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Feeder.getMotor1().set(speed);
    Feeder.getMotor2().set(speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Feeder.getMotor1().set(0);
    Feeder.getMotor2().set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
