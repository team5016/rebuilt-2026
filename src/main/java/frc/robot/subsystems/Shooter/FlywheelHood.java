package frc.robot.subsystems.Shooter;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FlywheelHood extends SubsystemBase {
    private final SparkMax motor = new SparkMax(2222, MotorType.kBrushless);

    public FlywheelHood() {
    }

    public Command open() {
        return Commands.race(this.run(() -> motor.set(0.15)), Commands.waitSeconds(2));
    }

    public Command close() {
        return Commands.race(this.run(() -> motor.set(-0.15)), Commands.waitSeconds(2));
    }
    
}
