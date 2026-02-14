package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExtendableHopper extends SubsystemBase {

  private final Solenoid solenoid = new Solenoid(PneumaticsModuleType.REVPH, 0);

  public Command toggleExtend() {
    // Starts "off" or retracted
    return this.runOnce(() -> solenoid.toggle());
  }
}
