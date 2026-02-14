package frc.robot.subsystems.Intake;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Collector extends SubsystemBase {

  private final SparkMax collectorMotor = new SparkMax(9, MotorType.kBrushless);

  public Command run() {
    return this.startEnd(
      () -> collectorMotor.set(0.5),
      () -> collectorMotor.set(0)
    );
  }
}
