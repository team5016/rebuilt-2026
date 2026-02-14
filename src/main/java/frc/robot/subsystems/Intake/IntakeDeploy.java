package frc.robot.subsystems.Intake;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeDeploy extends SubsystemBase {
    private final SparkMax IntakeMotor = new SparkMax(1, MotorType.kBrushless);

  public Command feed() {
    return this.startEnd(() -> IntakeMotor.set(-0.5), () -> IntakeMotor.set(0));
  }
}
