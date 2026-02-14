package frc.robot.subsystems.Shooter;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class FlywheelShooter extends SubsystemBase {
    private TalonFX krakenMotor;
        public void DriveSubsystem() {
            krakenMotor = new TalonFX(1);    
        var config = new TalonFXConfiguration();
        config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        krakenMotor.getConfigurator().apply(config);
    }
    public Command Shoot() {
        return this.startEnd(
        () -> {
            krakenMotor.set(0.5);
        },
        () -> {
            krakenMotor.set(0);
         }
        );
  }
}
